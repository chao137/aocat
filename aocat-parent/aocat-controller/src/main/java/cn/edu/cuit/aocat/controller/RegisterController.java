package cn.edu.cuit.aocat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.cuit.aocat.entity.User;
import cn.edu.cuit.aocat.service.UserService;

@Controller
public class RegisterController {

	@Autowired
	private UserService userService;

	@RequestMapping("/userRegister")
	public String userRegister(User user) {
		userService.insertUser(user);

		return "login";
	}

}
