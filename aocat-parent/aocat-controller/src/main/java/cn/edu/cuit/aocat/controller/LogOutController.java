package cn.edu.cuit.aocat.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogOutController {
	
	@RequestMapping("/tologout")
	public String LogOut(HttpSession session) {
		if(session != null) {
			session.invalidate();
		}
		return "redirect:tologin";
	}
}
