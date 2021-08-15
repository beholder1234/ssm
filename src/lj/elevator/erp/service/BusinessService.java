package lj.elevator.erp.service;

import java.util.List;

import lj.elevator.erp.pojo.Business;
import lj.elevator.erp.utils.Page;

public interface BusinessService {

	Page<Business> getBusinessList(Page<Business> page, String[] targets) throws Exception;

	Business getBusinessdetailList(Integer businessId);

	void insertBusinessAssign(Integer empid, Integer businessId, Integer[] empIds);

	boolean updateBusinessToOn(Integer businessId);

	boolean updateBusinessToFinish(Integer businessId);

	List<Business> getBusinessByequipmentIdAndType(Integer equipmentId, String type);

	void insertByBusiness(Business business);

}
