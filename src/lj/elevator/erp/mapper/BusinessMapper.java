package lj.elevator.erp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import lj.elevator.erp.pojo.Business;
import lj.elevator.erp.pojo.BusinessExample;
import lj.elevator.erp.utils.ConditionUtil;

public interface BusinessMapper {
	int countByExample(BusinessExample example);

	int deleteByExample(BusinessExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Business record);

	int insertSelective(Business record);

	List<Business> selectByExample(BusinessExample example);

	Business selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Business record, @Param("example") BusinessExample example);

	int updateByExample(@Param("record") Business record, @Param("example") BusinessExample example);

	int updateByPrimaryKeySelective(Business record);

	int updateByPrimaryKey(Business record);

	ArrayList<Business> selectByUtil(ConditionUtil conditionUtil);

	int countByUtil(ArrayList<String> conditionS);

	Business selectBusinessByKey(Integer id);
}