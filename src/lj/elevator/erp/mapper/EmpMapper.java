package lj.elevator.erp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import lj.elevator.erp.pojo.Emp;
import lj.elevator.erp.pojo.EmpExample;
import lj.elevator.erp.utils.ConditionUtil;

public interface EmpMapper {
	int countByExample(EmpExample example);

	int deleteByExample(EmpExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Emp record);

	int insertSelective(Emp record);

	List<Emp> selectByExample(EmpExample example);

	Emp selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Emp record, @Param("example") EmpExample example);

	int updateByExample(@Param("record") Emp record, @Param("example") EmpExample example);

	int updateByPrimaryKeySelective(Emp record);

	int updateByPrimaryKey(Emp record);

	ArrayList<Emp> selectByUtil(ConditionUtil conditionUtil);

	int countByUtil(ArrayList<String> conditionS);

	void deleteById(Integer empId);

	List<Emp> select();

}