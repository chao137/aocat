package cn.edu.cuit.aocat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.edu.cuit.aocat.entity.Goods;

public interface GoodsMapper {
	
	@Select("select goods_id as id,goods_name as name,goods_price as price,goods_num as num,goods_img as img,goods_type as type from goods")
	public List<Goods> findGoods();
	@Select("select goods_id as id,goods_name as name,goods_price as price,goods_num as num,goods_img as img,goods_type as type from goods where goods_id=#{id}")
	public Goods finByGoodsId(int id);
}
