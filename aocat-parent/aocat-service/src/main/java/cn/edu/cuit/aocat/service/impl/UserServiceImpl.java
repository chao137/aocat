package cn.edu.cuit.aocat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.cuit.aocat.mapper.UserMapper;
import cn.edu.cuit.aocat.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public boolean login(String name, String pass) {
		if (userMapper.findByNameAndPass(name,pass)>0) {
			return true;
		}
		return false;
	}

}
