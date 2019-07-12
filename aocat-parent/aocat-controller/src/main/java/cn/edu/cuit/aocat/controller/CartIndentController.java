package cn.edu.cuit.aocat.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.cuit.aocat.entity.Carts;
import cn.edu.cuit.aocat.entity.Goods;
import cn.edu.cuit.aocat.entity.GoodsAndItem;
import cn.edu.cuit.aocat.service.CartService;
import cn.edu.cuit.aocat.service.GoodsService;

@Controller
public class CartIndentController {

	@Autowired
	private CartService cartService;
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping("/toCartIndent")
	public String toCartIndent() {
		return "Cart-indent";
	}
	@RequestMapping("/getAmount")
	public String CalAmount(int uid,Model model) {
		List<GoodsAndItem> gmsg = new ArrayList<>();
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
			gmsg.add(gitem);
			amount += cart.getPrice();
		}
		model.addAttribute("gmsg",gmsg);
		model.addAttribute("amount",amount);
		return "forward:toCartIndent";
	}
}
