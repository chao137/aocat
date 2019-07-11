package cn.edu.cuit.aocat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	@RequestMapping("/toMember")
	public String toMember() {
		return "Member-allOrder";
	}
}
