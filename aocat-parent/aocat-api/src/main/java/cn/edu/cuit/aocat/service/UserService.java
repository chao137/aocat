package cn.edu.cuit.aocat.service;

import cn.edu.cuit.aocat.entity.User;

public interface UserService {

	User login(String name, String pass);

	void insertUser(User user);

}
