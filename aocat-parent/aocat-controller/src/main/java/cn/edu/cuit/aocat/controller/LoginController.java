package cn.edu.cuit.aocat.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping("/login")
	public String userLogin(@RequestParam("name") String name,@RequestParam("pass") String pass,HttpSession session) {
		User user = userService.login(name, pass);
		if (user != null) {
			session.setAttribute("user", user);
			return "list";
		}
//		model.addAttribute("msg", "用户名或 密码不正确！");
//		model.addAttribute("name", name);
		return "login";
	}
	
}