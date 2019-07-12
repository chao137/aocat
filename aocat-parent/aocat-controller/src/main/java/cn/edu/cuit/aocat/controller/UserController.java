package cn.edu.cuit.aocat.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.cuit.aocat.entity.User;
import cn.edu.cuit.aocat.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/touserInfo")
	public String toUserInfo(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
/*		System.out.println(user.getId());*/
		model.addAttribute("id", user.getId());
		model.addAttribute("name", user.getName());
		model.addAttribute("address", user.getAddress());
		model.addAttribute("phone", user.getPhone());
		return "userInfo";
	}
	
	@RequestMapping("/updateUserInfo")
	public String updateUserInfo(Model model,User user,HttpSession session) {
		System.out.println(user);
		userService.updateUser(user);
		
		session.setAttribute("user",user);
		
		model.addAttribute("id", user.getId());
		model.addAttribute("name", user.getName());
		model.addAttribute("address", user.getAddress());
		model.addAttribute("phone", user.getPhone());
		
		return "userInfo";
		
	}
}
