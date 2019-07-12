package cn.edu.cuit.aocat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.edu.cuit.aocat.entity.Goods;
import cn.edu.cuit.aocat.mapper.GoodsMapper;
import cn.edu.cuit.aocat.service.GoodsService;


@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
	
	@Autowired
	private GoodsMapper goodsMapper;

	@Override
	public PageInfo<Goods> findGoods(int pageNum, int pageSize) {
		//告诉从哪里开始
		PageHelper.startPage(pageNum, pageSize);
		List<Goods> list = goodsMapper.findGoods();
		PageInfo<Goods> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public Goods findByGoodsId(int id) {
		return goodsMapper.finByGoodsId(id);
	}

}
