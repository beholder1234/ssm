package lj.elevator.erp.service;

import java.util.List;

import lj.elevator.erp.pojo.Order;
import lj.elevator.erp.pojo.Orderdetail;
import lj.elevator.erp.pojo.Storedetail;
import lj.elevator.erp.utils.Page;

public interface StoredetailService {

	Page<Storedetail> getStoredetailList(Page<Storedetail> page, String[] targets) throws Exception;

	void insertStore(Order order, Orderdetail orderdetail);

	Storedetail getStoredetailByGoodsId(Integer goodsid);

	void outputStore(Order order, Orderdetail orderdetail);

	List<Storedetail> getStoreAlertList();

}
