package lj.elevator.erp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import lj.elevator.erp.pojo.Store;
import lj.elevator.erp.pojo.StoreExample;

public interface StoreMapper {
	int countByExample(StoreExample example);

	int deleteByExample(StoreExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Store record);

	int insertSelective(Store record);

	List<Store> selectByExample(StoreExample example);

	Store selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Store record, @Param("example") StoreExample example);

	int updateByExample(@Param("record") Store record, @Param("example") StoreExample example);

	int updateByPrimaryKeySelective(Store record);

	int updateByPrimaryKey(Store record);

	List<Store> select();
}