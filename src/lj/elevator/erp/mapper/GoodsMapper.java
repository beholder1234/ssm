package lj.elevator.erp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import lj.elevator.erp.pojo.Goods;
import lj.elevator.erp.pojo.GoodsExample;
import lj.elevator.erp.utils.ConditionUtil;

public interface GoodsMapper {
	int countByExample(GoodsExample example);

	int deleteByExample(GoodsExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Goods record);

	int insertSelective(Goods record);

	List<Goods> selectByExample(GoodsExample example);

	Goods selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

	int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

	int updateByPrimaryKeySelective(Goods record);

	int updateByPrimaryKey(Goods record);

	List<Goods> selectByUtil(ConditionUtil conditionUtil);

	int countByUtil(ArrayList<String> conditionS);

	void deleteGoodsById(Integer goodsId);

	List<String> selectName();

	List<String> selectModelNameBySupplierId(Integer suppId);

	List<String> selectModelName();
}