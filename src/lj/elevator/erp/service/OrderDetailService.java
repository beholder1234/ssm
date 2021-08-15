package lj.elevator.erp.service;

import java.util.List;

import lj.elevator.erp.pojo.Orderdetail;

public interface OrderDetailService {

	List<Orderdetail> getOrderdetailByOrderId(Integer orderId);

	void insertSelective(Orderdetail odetail);

	void updateState(Integer orderId, String state);

	void updateOrderdetail(Orderdetail orderdetail);

	Orderdetail getOrderdetailByKey(Integer id);

}
