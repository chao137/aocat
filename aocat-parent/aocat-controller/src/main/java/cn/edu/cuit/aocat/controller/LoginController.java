package cn.edu.cuit.aocat.controller;

import javax.servlet.http.HttpSession;

import org.apache.dubbo.common.json.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.PageInfo;

import cn.edu.cuit.aocat.constant.PageConstant;
import cn.edu.cuit.aocat.entity.Goods;
import cn.edu.cuit.aocat.entity.User;
import cn.edu.cuit.aocat.service.GoodsService;
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
	public String userLogin(@RequestParam("name") String name,@RequestParam("pass")String pass,HttpSession session) {
		User user = userService.login(name, pass);
		if (user != null) {
			session.setAttribute("user", user);
			return "forward:toGoods";
		}
		return "login";
	}
	
	
}