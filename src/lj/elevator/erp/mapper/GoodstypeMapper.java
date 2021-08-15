package lj.elevator.erp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import lj.elevator.erp.pojo.Goodstype;
import lj.elevator.erp.pojo.GoodstypeExample;

public interface GoodstypeMapper {
	int countByExample(GoodstypeExample example);

	int deleteByExample(GoodstypeExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Goodstype record);

	int insertSelective(Goodstype record);

	List<Goodstype> selectByExample(GoodstypeExample example);

	Goodstype selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Goodstype record, @Param("example") GoodstypeExample example);

	int updateByExample(@Param("record") Goodstype record, @Param("example") GoodstypeExample example);

	int updateByPrimaryKeySelective(Goodstype record);

	int updateByPrimaryKey(Goodstype record);

	List<Goodstype> select();
}