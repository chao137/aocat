package cn.edu.cuit.aocat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.edu.cuit.aocat.entity.Carts;

public interface CartMapper {
	
	@Insert("insert into shopitems(item_id,item_goods,item_price,item_num,item_user) values(default,#{goodsid},#{price},#{num},#{userid})")
	public int AddToCart(Carts cart);
	@Select("select item_id as id,item_goods as goodsid,item_price as price ,item_num as num,item_user as userid from shopitems where item_user = #{id}")
	public List<Carts> findItemsByUserId(int id);
	@Select("select item_id as id,item_goods as goodsid,item_price as price ,item_num as num,item_user as userid from shopitems where item_user = #{uid} and item_goods = #{gid}")
	public Carts findByUserIdAndGoodsId(@Param("uid")int uid,@Param("gid")int gid);
	@Select("select item_id as id,item_goods as goodsid,item_price as price ,item_num as num,item_user as userid from shopitems where item_id = #{id}")
	public Carts findByItemsId(int id);
	@Update("update shopitems set item_num = #{num} where item_id = #{id}")
	public int UpdateNum(Carts cart);
	@Delete("delete from shopitems where item_id = #{id}")
	public int DeleteCart(int id);
}
