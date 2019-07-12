package cn.edu.cuit.aocat.service.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.cuit.aocat.mapper.UserMapper;

public class UserServiceTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-service.xml");
		UserMapper userMapper = context.getBean(UserMapper.class);
		System.out.println(userMapper.findByNameAndPass("qq", "qq"));
	}

}
