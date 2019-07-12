package cn.edu.cuit.aocat.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.cuit.aocat.entity.Carts;
import cn.edu.cuit.aocat.mapper.CartMapper;
import cn.edu.cuit.aocat.service.CartService;

@Service("cartService")
public class CartServiceImpl implements CartService {

	@Autowired
	CartMapper cartMapper;
	@Override
	public int AddToCart(Carts carts) {
		int ret = cartMapper.AddToCart(carts);
		return ret;
	}

}
