package lj.elevator.erp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import lj.elevator.erp.pojo.Dictionary;
import lj.elevator.erp.pojo.DictionaryExample;

public interface DictionaryMapper {
	int countByExample(DictionaryExample example);

	int deleteByExample(DictionaryExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Dictionary record);

	int insertSelective(Dictionary record);

	List<Dictionary> selectByExample(DictionaryExample example);

	Dictionary selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Dictionary record, @Param("example") DictionaryExample example);

	int updateByExample(@Param("record") Dictionary record, @Param("example") DictionaryExample example);

	int updateByPrimaryKeySelective(Dictionary record);

	int updateByPrimaryKey(Dictionary record);

	List<Dictionary> select();
}