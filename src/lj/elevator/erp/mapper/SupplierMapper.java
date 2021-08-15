package lj.elevator.erp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import lj.elevator.erp.pojo.Customer;
import lj.elevator.erp.pojo.Supplier;
import lj.elevator.erp.pojo.SupplierExample;
import lj.elevator.erp.utils.ConditionUtil;

public interface SupplierMapper {
	int countByExample(SupplierExample example);

	int deleteByExample(SupplierExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Supplier record);

	int insertSelective(Supplier record);

	List<Supplier> selectByExample(SupplierExample example);

	Supplier selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Supplier record, @Param("example") SupplierExample example);

	int updateByExample(@Param("record") Supplier record, @Param("example") SupplierExample example);

	int updateByPrimaryKeySelective(Supplier record);

	int updateByPrimaryKey(Supplier record);

	ArrayList<Customer> selectByUtil(ConditionUtil conditionUtil);

	int countByUtil(ArrayList<String> conditionS);

	List<Supplier> select();
}