package cn.edu.cuit.aocat.service.impl;


import java.util.List;

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
	@Override
	public List<Carts> findItemsByUserId(int id) {
		return cartMapper.findItemsByUserId(id);
	}
	@Override
	public Carts findByUserIdAndGoodsId(int uid, int gid) {
		return cartMapper.findByUserIdAndGoodsId(uid, gid);
	}
	@Override
	public int UpdateNum(Carts cart) {
		return cartMapper.UpdateNum(cart);
	}
	@Override
	public int DeleteCart(int id) {
		return cartMapper.DeleteCart(id);
	}
	@Override
	public Carts findByItemsId(int id) {
		return cartMapper.findByItemsId(id);
	}
	@Override
	public int UpdatePrice(Carts cart) {
		return cartMapper.UpdatePrice(cart);
	}

}
