package cn.edu.cuit.aocat.mapper;

import org.apache.ibatis.annotations.Insert;

import cn.edu.cuit.aocat.entity.Carts;

public interface CartMapper {
	
	@Insert("insert into shopitems(item_id,item_goods,item_price,item_num,item_user) values(default,#{goodsid},#{price},#{num},#{userid})")
	public int AddToCart(Carts cart);
}
