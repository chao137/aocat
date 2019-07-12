package cn.edu.cuit.aocat.service;

import cn.edu.cuit.aocat.entity.User;

public interface UserService {

	User login(String name, String pass);
	User findByUserId(int id);
	boolean insertUser(User user);
	void updateUser(User user);
}
