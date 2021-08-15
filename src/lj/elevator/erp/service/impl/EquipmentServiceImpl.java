package lj.elevator.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lj.elevator.erp.mapper.EquipmentMapper;
import lj.elevator.erp.pojo.Customer;
import lj.elevator.erp.pojo.Equipment;
import lj.elevator.erp.service.CustomerService;
import lj.elevator.erp.service.EquipmentService;
import lj.elevator.erp.utils.ComServiceUtil;
import lj.elevator.erp.utils.Page;

@Service
public class EquipmentServiceImpl implements EquipmentService {

	@Autowired
	private EquipmentMapper equipmentMapper;

	@Autowired
	private CustomerService customerService;

	@Override
	public Page<Equipment> getEquipmentList(Page<Equipment> page, String[] targets) throws Exception {

		ComServiceUtil<EquipmentMapper, Equipment> comServiceUtil = new ComServiceUtil<EquipmentMapper, Equipment>(
				equipmentMapper, page, targets);

		page = comServiceUtil.getPage();

		return page;
	}

	@Override
	public Equipment getEquipmentByKey(Integer id) {

		Equipment equipment = equipmentMapper.selectByPrimaryKey(id);

		if (equipment.getCustomerid() != null) {
			Customer customer = customerService.getCustomerByKey(equipment.getCustomerid());
			equipment.setCustomer(customer);
		}

		return equipment;
	}

	@Override
	public void updateByEquipment(Equipment equipment) {
		equipmentMapper.updateByPrimaryKeySelective(equipment);

	}

	@Override
	public List<Equipment> select() {
		List<Equipment> equipments = equipmentMapper.select();
		return equipments;
	}

	@Override
	public void insertEquipment(Equipment equipment) {

		equipmentMapper.insertSelective(equipment);

	}
}
