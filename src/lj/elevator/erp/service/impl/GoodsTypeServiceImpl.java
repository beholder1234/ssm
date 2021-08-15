package lj.elevator.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lj.elevator.erp.mapper.GoodstypeMapper;
import lj.elevator.erp.pojo.Goodstype;
import lj.elevator.erp.pojo.GoodstypeExample;
import lj.elevator.erp.pojo.GoodstypeExample.Criteria;
import lj.elevator.erp.service.GoodsTypeService;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

	@Autowired
	private GoodstypeMapper gTypeMapper;

	@Override
	public List<Goodstype> getGoodsType() {
		List<Goodstype> goodstypes = gTypeMapper.select();
		return goodstypes;
	}

	@Override
	public List<Goodstype> selectByName(String name) {

		GoodstypeExample goodstypeExample = new GoodstypeExample();

		Criteria criteria = goodstypeExample.createCriteria();
		criteria.andNameEqualTo(name);

		List<Goodstype> goodstypes = gTypeMapper.selectByExample(goodstypeExample);

		return goodstypes;

	}

	@Override
	public Goodstype getGoodsTypeById(Integer goodstypeid) {

		Goodstype goodstype = gTypeMapper.selectByPrimaryKey(goodstypeid);
		return goodstype;
	}

}
