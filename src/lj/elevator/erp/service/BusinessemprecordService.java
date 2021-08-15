package lj.elevator.erp.service;

import java.util.List;

import lj.elevator.erp.pojo.Business;
import lj.elevator.erp.pojo.Businessemprecord;
import lj.elevator.erp.utils.Page;

public interface BusinessemprecordService {

	List<Businessemprecord> getBusinessDetailByBusinessId(Integer businessId);

	Page<Business> getBusinessDetailByPage(Page<Business> page);

	void insertRecord(Integer businessId, Integer empid, String workType);

	List<Businessemprecord> selectByEmpId(Integer empid);

}
