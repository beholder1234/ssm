package lj.elevator.erp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import lj.elevator.erp.pojo.Goodsprice;
import lj.elevator.erp.pojo.GoodspriceExample;

public interface GoodspriceMapper {
	int countByExample(GoodspriceExample example);

	int deleteByExample(GoodspriceExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Goodsprice record);

	int insertSelective(Goodsprice record);

	List<Goodsprice> selectByExample(GoodspriceExample example);

	Goodsprice selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Goodsprice record, @Param("example") GoodspriceExample example);

	int updateByExample(@Param("record") Goodsprice record, @Param("example") GoodspriceExample example);

	int updateByPrimaryKeySelective(Goodsprice record);

	int updateByPrimaryKey(Goodsprice record);

}