package cn.edu.cuit.aocat.service;

import java.util.List;

import cn.edu.cuit.aocat.entity.Carts;

public interface CartService {
	public int AddToCart(Carts carts);
	public List<Carts> findItemsByUserId(int id);
	public Carts findByUserIdAndGoodsId(int uid,int gid);
	public int UpdateNum(Carts cart);
	public int DeleteCart(int id);
	public Carts findByItemsId(int id);
	public int UpdatePrice(Carts cart);
}
