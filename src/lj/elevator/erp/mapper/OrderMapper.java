package lj.elevator.erp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import lj.elevator.erp.pojo.Order;
import lj.elevator.erp.pojo.OrderExample;
import lj.elevator.erp.utils.ConditionUtil;

public interface OrderMapper {
	int countByExample(OrderExample example);

	int deleteByExample(OrderExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Order record);

	int insertSelective(Order record);

	List<Order> selectByExample(OrderExample example);

	Order selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

	int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

	int updateByPrimaryKeySelective(Order record);

	int updateByPrimaryKey(Order record);

	List<Order> selectByUtil(ConditionUtil conditionUtil);

	int countByUtil(ArrayList<String> conditionS);

	List<Integer> selectSameGoodsNum();

	List<Integer> selectSameGoodsId();
}