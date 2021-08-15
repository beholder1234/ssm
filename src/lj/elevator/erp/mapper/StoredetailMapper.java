package lj.elevator.erp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import lj.elevator.erp.pojo.Storedetail;
import lj.elevator.erp.pojo.StoredetailExample;
import lj.elevator.erp.utils.ConditionUtil;

public interface StoredetailMapper {
	int countByExample(StoredetailExample example);

	int deleteByExample(StoredetailExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Storedetail record);

	int insertSelective(Storedetail record);

	List<Storedetail> selectByExample(StoredetailExample example);

	Storedetail selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Storedetail record, @Param("example") StoredetailExample example);

	int updateByExample(@Param("record") Storedetail record, @Param("example") StoredetailExample example);

	int updateByPrimaryKeySelective(Storedetail record);

	int updateByPrimaryKey(Storedetail record);

	List<Storedetail> selectByUtil(ConditionUtil conditionUtil);

	int countByUtil(ArrayList<String> list);

	List<Storedetail> getStoreAlertList();
}