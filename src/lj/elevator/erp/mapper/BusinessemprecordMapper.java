package lj.elevator.erp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import lj.elevator.erp.pojo.Businessemprecord;
import lj.elevator.erp.pojo.BusinessemprecordExample;

public interface BusinessemprecordMapper {
	int countByExample(BusinessemprecordExample example);

	int deleteByExample(BusinessemprecordExample example);

	int insert(Businessemprecord record);

	int insertSelective(Businessemprecord record);

	List<Businessemprecord> selectByExample(BusinessemprecordExample example);

	int updateByExampleSelective(@Param("record") Businessemprecord record,
			@Param("example") BusinessemprecordExample example);

	int updateByExample(@Param("record") Businessemprecord record, @Param("example") BusinessemprecordExample example);

	List<Businessemprecord> selectByBusinessId(Integer businessId);

	List<Businessemprecord> selectByEmpId(Integer empid);
}