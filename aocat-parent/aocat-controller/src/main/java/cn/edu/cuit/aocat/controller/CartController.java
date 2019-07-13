package cn.edu.cuit.aocat.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.cuit.aocat.entity.Carts;
import cn.edu.cuit.aocat.entity.Goods;
import cn.edu.cuit.aocat.entity.GoodsAndItem;
import cn.edu.cuit.aocat.entity.User;
import cn.edu.cuit.aocat.service.CartService;
import cn.edu.cuit.aocat.service.GoodsService;
import cn.edu.cuit.aocat.service.UserService;

@Controller
public class CartController {

	@Autowired
	private UserService userService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private CartService cartService;
	
	@RequestMapping("/toCart")
	public String toCart() {
		return "Cart";
	}
	
	@RequestMapping("/addToCart")
	public String addGoods(@RequestParam("uid")String userid,@RequestParam("gid")String goodsid) {
		int uid = Integer.parseInt(userid);
		int gid = Integer.parseInt(goodsid);
		
		User user = userService.findByUserId(uid);
		Goods goods = goodsService.findByGoodsId(gid);
		Carts cart2 = cartService.findByUserIdAndGoodsId(uid, gid);
		if (cart2 != null) {
			//如果商品已存在，则更改数量
			cart2.setNum(cart2.getNum()+1);
			cartService.UpdateNum(cart2);
		}
		else {
			Carts carts = new Carts();
			carts.setGoodsid(gid);
			carts.setNum(1);
			carts.setPrice(goods.getPrice());
			carts.setUserid(uid);
			//添加进购物车
			int ret = cartService.AddToCart(carts);
			System.out.println(ret);
		}
		return "forward:getItems";
	}
	
	@RequestMapping("/getItems")
	public String ShowItems(int uid,Model model){
		
		List<GoodsAndItem> glist = new ArrayList<>();
		List<Carts> clist = cartService.findItemsByUserId(uid);
		Iterator<Carts> iter = clist.iterator();
		double amount = 0;
		while(iter.hasNext()) {
			Carts cart = iter.next();
			Goods goods = goodsService.findByGoodsId(cart.getGoodsid());
			GoodsAndItem gitem = new GoodsAndItem();
			gitem.setGid(goods.getId());
			gitem.setImg(goods.getImg());
			gitem.setName(goods.getName());
			gitem.setPrice(cart.getPrice());
			gitem.setSinglePrice(goods.getPrice());
			gitem.setType(goods.getType());
			gitem.setUid(uid);
			gitem.setUnum(cart.getNum());
			gitem.setItemid(cart.getId());
			glist.add(gitem);
			amount += cart.getPrice();
		}
		model.addAttribute("glist",glist);
		model.addAttribute("mount",amount);
		return "Cart";
	}
	
	@RequestMapping("/deleteCart")
	@ResponseBody
	public String DeleteCart(int id) {
		int ret = cartService.DeleteCart(id);
		String status = null;
		if(ret > 0) {
			status = "sucess";
		}
		else {
			status = "failed";
		}
		return status;
	}
	
	@RequestMapping("/updateNum")
	@ResponseBody
	public String UpdateNum(@RequestParam("itemid")int itemsid,@RequestParam("itemnum")int itemsnum) {
		System.out.println("id:"+itemsid+"num:"+itemsnum);
		Carts carts = cartService.findByItemsId(itemsid);
		Goods goods = goodsService.findByGoodsId(carts.getGoodsid());
		carts.setNum(itemsnum);
//		System.out.println(carts.getPrice());
		int ret = cartService.UpdateNum(carts);
		carts.setPrice(itemsnum*goods.getPrice());
		int rt = cartService.UpdatePrice(carts);
		System.out.println("line:"+rt);
		String status = null; 
		if(ret > 0) {
			status = "success";
		}
		else {
			status = "failed";
		}
		return status;
	}
}
