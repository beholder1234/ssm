package lj.elevator.erp.service;

import java.util.List;

import lj.elevator.erp.pojo.Goodsprice;
import lj.elevator.erp.pojo.Orderdetail;

public interface GoodspriceService {

	public List<Goodsprice> selectGoodspriceByGoodId(Integer goodsId);

	public void insertPrice(Orderdetail orderdetail);

	public void outputPrice(Orderdetail orderdetail);

}
