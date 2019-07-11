package cn.edu.cuit.aocat.service;

import com.github.pagehelper.PageInfo;

import cn.edu.cuit.aocat.entity.Goods;

public interface GoodsService {

	public PageInfo<Goods> findGoods(int pageNum, int pageSize);

}
