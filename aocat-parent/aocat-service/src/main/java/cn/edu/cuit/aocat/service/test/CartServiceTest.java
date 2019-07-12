package cn.edu.cuit.aocat.service.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.cuit.aocat.entity.Carts;
import cn.edu.cuit.aocat.mapper.CartMapper;
import cn.edu.cuit.aocat.mapper.UserMapper;
import cn.edu.cuit.aocat.service.CartService;

public class CartServiceTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-service.xml");
		CartService carservice = context.getBean(CartService.class);
		Carts carts = new Carts();
		carts.setGoodsid(1);
		carts.setNum(1);
		carts.setPrice(230);
		carts.setUserid(8);
		int ret = carservice.AddToCart(carts);
		System.out.println(ret);
		
	}

}
