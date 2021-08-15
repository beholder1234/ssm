package lj.elevator.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lj.elevator.erp.mapper.OrderdetailMapper;
import lj.elevator.erp.pojo.Orderdetail;
import lj.elevator.erp.pojo.OrderdetailExample;
import lj.elevator.erp.pojo.OrderdetailExample.Criteria;
import lj.elevator.erp.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	private OrderdetailMapper orderdetailMapper;

	@Override
	public List<Orderdetail> getOrderdetailByOrderId(Integer orderId) {

		System.out.println("ID:" + orderId);
		List<Orderdetail> orderdetails = orderdetailMapper.selectOrderdetailByOrderId(orderId);
		System.out.println("OrderDetailService Our....");
		return orderdetails;
	}

	@Override
	public void insertSelective(Orderdetail odetail) {

		orderdetailMapper.insertSelective(odetail);
		System.out.println("Add orderdetail....");
	}

	@Override
	public void updateState(Integer orderId, String state) {

		OrderdetailExample example = new OrderdetailExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrderidEqualTo(orderId);

		List<Orderdetail> orderdetails = orderdetailMapper.selectByExample(example);

		for (Orderdetail orderdetail : orderdetails) {
			orderdetail.setState(state);
			orderdetailMapper.updateByPrimaryKeySelective(orderdetail);
		}

	}

	@Override
	public void updateOrderdetail(Orderdetail orderdetail) {

		orderdetailMapper.updateByPrimaryKeySelective(orderdetail);

	}

	@Override
	public Orderdetail getOrderdetailByKey(Integer id) {
		Orderdetail orderdetail = orderdetailMapper.selectByPrimaryKey(id);
		return orderdetail;
	}
}
