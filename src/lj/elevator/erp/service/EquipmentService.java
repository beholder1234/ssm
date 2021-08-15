package lj.elevator.erp.service;

import java.util.List;

import lj.elevator.erp.pojo.Equipment;
import lj.elevator.erp.utils.Page;

public interface EquipmentService {

	Page<Equipment> getEquipmentList(Page<Equipment> page, String[] targets) throws Exception;

	Equipment getEquipmentByKey(Integer id);

	void updateByEquipment(Equipment equipment);

	List<Equipment> select();

	void insertEquipment(Equipment equipment);

}
