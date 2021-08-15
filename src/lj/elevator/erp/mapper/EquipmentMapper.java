package lj.elevator.erp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import lj.elevator.erp.pojo.Equipment;
import lj.elevator.erp.pojo.EquipmentExample;
import lj.elevator.erp.utils.ConditionUtil;

public interface EquipmentMapper {
	int countByExample(EquipmentExample example);

	int deleteByExample(EquipmentExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Equipment record);

	int insertSelective(Equipment record);

	List<Equipment> selectByExample(EquipmentExample example);

	Equipment selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Equipment record, @Param("example") EquipmentExample example);

	int updateByExample(@Param("record") Equipment record, @Param("example") EquipmentExample example);

	int updateByPrimaryKeySelective(Equipment record);

	int updateByPrimaryKey(Equipment record);

	List<Equipment> selectByUtil(ConditionUtil conditionUtil);

	int countByUtil(ArrayList<String> conditionS);

	List<Equipment> select();
}