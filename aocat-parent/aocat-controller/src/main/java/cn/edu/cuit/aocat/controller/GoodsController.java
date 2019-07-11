package cn.edu.cuit.aocat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import cn.edu.cuit.aocat.entity.Goods;
import cn.edu.cuit.aocat.service.GoodsService;

//这里是GoodsController
@Controller
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping("/goods")
	public String GoodsList(Model model, @RequestParam(required=false,defaultValue="1")int pageNum) {
		PageInfo<Goods> pageInfo = goodsService.findGoods(pageNum, 5);
		model.addAttribute("list", pageInfo);
		return "goodsList";
	}
}
