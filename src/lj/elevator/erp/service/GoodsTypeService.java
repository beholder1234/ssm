package lj.elevator.erp.service;

import java.util.List;

import lj.elevator.erp.pojo.Goodstype;

public interface GoodsTypeService {
	public List<Goodstype> getGoodsType();

	public List<Goodstype> selectByName(String name);

	public Goodstype getGoodsTypeById(Integer goodstypeid);

}
