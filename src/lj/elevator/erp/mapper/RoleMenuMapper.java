package lj.elevator.erp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import lj.elevator.erp.pojo.RoleMenu;
import lj.elevator.erp.pojo.RoleMenuExample;

public interface RoleMenuMapper {
	int countByExample(RoleMenuExample example);

	int deleteByExample(RoleMenuExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(RoleMenu record);

	int insertSelective(RoleMenu record);

	List<RoleMenu> selectByExample(RoleMenuExample example);

	RoleMenu selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") RoleMenu record, @Param("example") RoleMenuExample example);

	int updateByExample(@Param("record") RoleMenu record, @Param("example") RoleMenuExample example);

	int updateByPrimaryKeySelective(RoleMenu record);

	int updateByPrimaryKey(RoleMenu record);

	List<RoleMenu> getMenuList(Integer roleId);
}