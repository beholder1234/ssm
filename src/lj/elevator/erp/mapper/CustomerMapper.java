package lj.elevator.erp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import lj.elevator.erp.pojo.Customer;
import lj.elevator.erp.pojo.CustomerExample;
import lj.elevator.erp.utils.ConditionUtil;

public interface CustomerMapper {
	int countByExample(CustomerExample example);

	int deleteByExample(CustomerExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Customer record);

	int insertSelective(Customer record);

	List<Customer> selectByExample(CustomerExample example);

	Customer selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

	int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

	int updateByPrimaryKeySelective(Customer record);

	int updateByPrimaryKey(Customer record);

	ArrayList<Customer> selectByUtil(ConditionUtil conditionUtil);

	int countByUtil(ArrayList<String> conditionS);

	List<Customer> select();
}