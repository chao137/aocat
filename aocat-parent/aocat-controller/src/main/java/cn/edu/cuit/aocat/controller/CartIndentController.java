package cn.edu.cuit.aocat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartIndentController {

	@RequestMapping("/toCartIndent")
	public String toCartIndent() {
		return "Cart-indent";
	}
	
//	public String CalAmount() {
//		
//	}
}
