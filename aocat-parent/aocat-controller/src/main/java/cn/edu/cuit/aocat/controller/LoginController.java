package cn.edu.cuit.aocat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.cuit.aocat.service.UserService;


@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/tologin")
	public String login() {
		
		return "login";
	}
	
	@RequestMapping("/login")
	public String userLogin(@RequestParam("name") String name,@RequestParam("pass") String pass,Model model) {
		if (userService.login(name,pass)) {
			return "success";
		}
		model.addAttribute("msg", "用户名或 密码不正确！");
		model.addAttribute("name", name);
		return "login";
	}
	

}
