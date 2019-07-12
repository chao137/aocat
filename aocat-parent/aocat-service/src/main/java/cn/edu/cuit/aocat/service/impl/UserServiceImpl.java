package cn.edu.cuit.aocat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.cuit.aocat.entity.User;
import cn.edu.cuit.aocat.mapper.UserMapper;
import cn.edu.cuit.aocat.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User login(String name, String pass) {
		User user = userMapper.findByNameAndPass(name, pass);
		return user;
	}

	@Override
	public User findByUserId(int id) {
		return userMapper.findByUserId(id);
	}
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		int ret = userMapper.findByName(user.getName());
		if (ret > 0) {
			return false;
		} else {
			userMapper.insertUser(user);
			return true;
		}
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userMapper.updateUserInfo(user);
	}

}
