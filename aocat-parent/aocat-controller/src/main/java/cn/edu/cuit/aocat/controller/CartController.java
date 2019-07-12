package cn.edu.cuit.aocat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.cuit.aocat.entity.Carts;
import cn.edu.cuit.aocat.entity.Goods;
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
		System.out.println(user);
		System.out.println(goods);
		Carts carts = new Carts();
		carts.setGoodsid(gid);
		carts.setNum(1);
		carts.setPrice(goods.getPrice());
		carts.setUserid(uid);
		int ret = cartService.AddToCart(carts);
		System.out.println(ret);
		return "forward:toCart";
	}
}
