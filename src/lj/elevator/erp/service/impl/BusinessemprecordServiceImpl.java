package lj.elevator.erp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lj.elevator.erp.mapper.BusinessemprecordMapper;
import lj.elevator.erp.pojo.Business;
import lj.elevator.erp.pojo.Businessemprecord;
import lj.elevator.erp.service.BusinessemprecordService;
import lj.elevator.erp.utils.Page;

@Service
public class BusinessemprecordServiceImpl implements BusinessemprecordService {

	@Autowired
	private BusinessemprecordMapper mapper;

	@Override
	public Page<Business> getBusinessDetailByPage(Page<Business> page) {
		ArrayList<Business> list = new ArrayList<Business>();
		for (Business business : page.getRows()) {
			List<Businessemprecord> emprecords = mapper.selectByBusinessId(business.getId());
			business.setBusinessemprecords(emprecords);
			list.add(business);

		}

		page.setRows(list);
		return page;
	}

	@Override
	public List<Businessemprecord> getBusinessDetailByBusinessId(Integer businessId) {
		List<Businessemprecord> emprecords = mapper.selectByBusinessId(businessId);
		System.out.println("你");
		return emprecords;
	}

	@Override
	public void insertRecord(Integer businessId, Integer empid, String worktype) {

		Businessemprecord record = new Businessemprecord();
		record.setEmpid(empid);
		record.setBusinessid(businessId);
		record.setWorktype(worktype);
		mapper.insertSelective(record);

	}

	@Override
	public List<Businessemprecord> selectByEmpId(Integer empid) {

		List<Businessemprecord> list = mapper.selectByEmpId(empid);
		return list;
	}
}
