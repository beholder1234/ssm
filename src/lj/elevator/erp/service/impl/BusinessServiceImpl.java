package lj.elevator.erp.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lj.elevator.erp.mapper.BusinessMapper;
import lj.elevator.erp.pojo.Business;
import lj.elevator.erp.pojo.BusinessExample;
import lj.elevator.erp.pojo.BusinessExample.Criteria;
import lj.elevator.erp.pojo.Businessemprecord;
import lj.elevator.erp.pojo.Equipment;
import lj.elevator.erp.pojo.Order;
import lj.elevator.erp.service.BusinessService;
import lj.elevator.erp.service.BusinessemprecordService;
import lj.elevator.erp.service.EquipmentService;
import lj.elevator.erp.service.OrderService;
import lj.elevator.erp.utils.ComServiceUtil;
import lj.elevator.erp.utils.DateUtil;
import lj.elevator.erp.utils.Page;

@Service
public class BusinessServiceImpl implements BusinessService {

	@Autowired
	private BusinessMapper businessMapper;

	@Autowired
	private BusinessemprecordService bemprecordService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private EquipmentService equipmentService;

	@Override
	public Page<Business> getBusinessList(Page<Business> page, String[] targets) throws Exception {

		ComServiceUtil<BusinessMapper, Business> comServiceUtil = new ComServiceUtil<BusinessMapper, Business>(
				businessMapper, page, targets);
		page = comServiceUtil.getPage();

		page = bemprecordService.getBusinessDetailByPage(page);
		return page;
	}

	@Override
	public Business getBusinessdetailList(Integer businessId) {

		Business business = businessMapper.selectBusinessByKey(businessId);

		List<Businessemprecord> businessemprecords = bemprecordService.getBusinessDetailByBusinessId(businessId);

		business.setBusinessemprecords(businessemprecords);

		return business;
	}

	@Override
	// empid：分配工作的emp的id
	// businessId：被分配的业务的id
	// empIds：处理工作的emp的id
	public void insertBusinessAssign(Integer empid, Integer businessId, Integer[] empIds) {

		// 对business进行分派
		bemprecordService.insertRecord(businessId, empid, "1");

		for (Integer integer : empIds) {
			bemprecordService.insertRecord(businessId, empid, "2");
		}

		// 对business的状态进行改变
		Business business = businessMapper.selectBusinessByKey(businessId);
		business.setState("2");
		businessMapper.updateByPrimaryKey(business);
	}

	@Override
	public boolean updateBusinessToOn(Integer businessId) {

		Business business = businessMapper.selectBusinessByKey(businessId);

		if (business.getType().equals("1")) {
			Order order = orderService.getOrderByKey(business.getOrderid());
			if (!order.getState().equals("6")) {
				return false;
			}
			Equipment equipment = business.getEquipment();
			equipment.setInstalltime(new Date());
			equipmentService.updateByEquipment(equipment);
		}

		business.setState("3");
		business.setStarttime(new Date());
		businessMapper.updateByPrimaryKeySelective(business);

		return true;
	}

	@Override
	public boolean updateBusinessToFinish(Integer businessId) {
		Business business = businessMapper.selectBusinessByKey(businessId);

		if (!business.getState().equals("3")) {
			System.out.println("业务未处理,则不可确定处理完成.....");
			return false;
		}
		// 通过业务类型分别设置不同数据
		// 设置 business 为已完成（4），与结束时间
		// 将equipment 状态为运行（2），new 运行时间（opertime）
		// 安检时间（Secexamtime）,当前时间加15天，年审时间（Annualexamtime），当前时间加1年

		business.setState("4");
		business.setEndtime(new Date());
		businessMapper.updateByPrimaryKeySelective(business);
		Equipment equipment = business.getEquipment();

		// 安装
		if (business.getType().equals("1")) {

			equipment.setState("2");
			equipment.setOpertime(new Date());

			DateUtil dateUtil = new DateUtil(new Date());
			Date date = dateUtil.changeDate(null, null, 15);
			equipment.setSecexamtime(date);

			date = dateUtil.changeDate(1, null, null);
			equipment.setAnnualexamtime(date);

			equipmentService.updateByEquipment(equipment);
		}
		// 安检
		else if (business.getType().equals("2")) {
			DateUtil dateUtil = new DateUtil(new Date());
			Date date = dateUtil.changeDate(null, null, 15);
			equipment.setSecexamtime(date);
			equipmentService.updateByEquipment(equipment);
		}
		// 年审
		else if (business.getType().equals("3")) {
			DateUtil dateUtil = new DateUtil(new Date());
			Date date = dateUtil.changeDate(1, null, null);
			equipment.setAnnualexamtime(date);
			equipmentService.updateByEquipment(equipment);
		}

		return true;

	}

	@Override
	public List<Business> getBusinessByequipmentIdAndType(Integer equipmentId, String type) {
		BusinessExample example = new BusinessExample();
		Criteria criteria = example.createCriteria();
		criteria.andEquipmentidEqualTo(equipmentId);
		criteria.andTypeEqualTo(type);
		List<Business> businesses = businessMapper.selectByExample(example);

		return businesses;
	}

	@Override
	public void insertByBusiness(Business business) {
		businessMapper.insertSelective(business);

	}

}
