package cn.edu.cuit.aocat.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.cuit.aocat.entity.User;
import cn.edu.cuit.aocat.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping("/tologin")
	public String login() {
		return "login";
	}

	@RequestMapping("/toRegister")
	public String toRegister() {
		return "register";
	}
	
	@RequestMapping("toUserInfo")
	public String toUserInfo() {
		return "forward:touserInfo";
	}

	@RequestMapping("/login")
	public String userLogin(@RequestParam("name") String name,@RequestParam("pass")String pass,HttpSession session) {
		User user = userService.login(name, pass);
		if (user != null) {
			session.setAttribute("user", user);
			return "forward:toGoods";
		}
		return "login";
	}
}