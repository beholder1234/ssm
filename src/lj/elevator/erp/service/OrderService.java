package lj.elevator.erp.service;

import java.util.List;

import lj.elevator.erp.pojo.Customer;
import lj.elevator.erp.pojo.Order;
import lj.elevator.erp.pojo.Supplier;
import lj.elevator.erp.utils.Page;

public interface OrderService {

	Page<Order> getOrderList(Page<Order> page, String[] targets) throws Exception;

	Order setOrderdetail(Page<Order> page, Integer orderId);

	void addPOrder(Supplier supplier, Integer[] goodsId, Integer[] num, Float[] price);

	void verifyPOrder(Integer orderId, Integer checkerId);

	void finishPur(Integer orderId, Integer starterId);

	Page<Order> setOrderdetail(Page<Order> page);

	void putGoodsInStore(Integer orderId, Integer orderdetailId, Integer storekeeperId);

	void addSOrder(Customer customer, Integer[] goodsId, Integer[] num, Float[] price);

	boolean verifySOrder(Integer orderId, Integer checkerId);

	boolean putGoodsOutStore(Integer orderId, Integer orderdetailId, Integer storekeeperId);

	void startGetGoods(Integer orderId, Integer starterId);

	Order getOrderByKey(Integer orderid);

	List<Integer> getOrNumArByM(String type);

	List<Integer> selectSameGoodsNumForNotes();

	List<Integer> selectSameGoodsIdForNotes();

}
