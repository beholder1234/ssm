package lj.elevator.erp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lj.elevator.erp.pojo.Business;
import lj.elevator.erp.pojo.Dictionary;
import lj.elevator.erp.pojo.Equipment;
import lj.elevator.erp.pojo.RoleMenu;
import lj.elevator.erp.service.BusinessService;
import lj.elevator.erp.service.DepService;
import lj.elevator.erp.service.DictionaryService;
import lj.elevator.erp.service.EquipmentService;
import lj.elevator.erp.service.GoodsTypeService;
import lj.elevator.erp.service.LoginService;
import lj.elevator.erp.service.RoleMenuService;
import lj.elevator.erp.service.RoleService;
import lj.elevator.erp.service.StoreService;
import lj.elevator.erp.service.SupplierService;
import lj.elevator.erp.utils.DateUtil;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private DepService depService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private GoodsTypeService gTypeService;

	@Autowired
	private SupplierService supplierService;

	@Autowired
	private StoreService storeService;

	@Autowired
	private DictionaryService dictionaryService;

	@Autowired
	private EquipmentService equipmentService;

	@Autowired
	private BusinessService businessService;

	@Autowired
	private RoleMenuService roleMenuService;

	@Override
	public Map<String, Object> getLoadInDate() {

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("deps", depService.getDep());
		map.put("roles", roleService.getRole());
		map.put("goodstypes", gTypeService.getGoodsType());
		map.put("stores", storeService.getStore());

		List<Dictionary> dictionaries = dictionaryService.getDictionary();

		List<List<Dictionary>> lists = this.splitDictionary(dictionaries);

		map.put("ordertypes", lists.get(0));
		map.put("orderStates", lists.get(1));
		map.put("orderdetailStates", lists.get(2));
		map.put("equipmentNames", lists.get(3));
		map.put("equipmentStates", lists.get(4));
		map.put("businessTypes", lists.get(5));
		map.put("businessWorkTypes", lists.get(6));
		map.put("businessStates", lists.get(7));

		return map;
	}

	private List<List<Dictionary>> splitDictionary(List<Dictionary> dictionarys) {

		List<Dictionary> OrderTypes = new ArrayList<Dictionary>();
		List<Dictionary> OrderStates = new ArrayList<Dictionary>();
		List<Dictionary> OrderdetailStates = new ArrayList<Dictionary>();
		List<Dictionary> EquipmentNames = new ArrayList<Dictionary>();
		List<Dictionary> EquipmentStates = new ArrayList<Dictionary>();
		List<Dictionary> BusinessTypes = new ArrayList<Dictionary>();
		List<Dictionary> BusinessWorkTypes = new ArrayList<Dictionary>();
		List<Dictionary> BusinessStates = new ArrayList<Dictionary>();

		for (Dictionary one : dictionarys) {

			switch (one.getTypecode()) {
			case "Order_Type": {
				OrderTypes.add(one);

				break;
			}
			case "Order_State": {
				OrderStates.add(one);

				break;
			}
			case "Orderdetail_State": {

				OrderdetailStates.add(one);
				break;
			}
			case "Equipment_Name": {
				System.out.println("Equipment_Name");
				EquipmentNames.add(one);
				break;
			}
			case "Equipment_State": {
				System.out.println("Equipment_State");
				EquipmentStates.add(one);
				break;
			}
			case "Business_Type": {
				System.out.println("Business_Type");
				BusinessTypes.add(one);
				break;
			}
			case "BusinessWork_Type": {
				System.out.println("BusinessWorkTypes");
				BusinessWorkTypes.add(one);
				break;
			}
			case "Business_State": {
				System.out.println("Business_State");
				BusinessStates.add(one);
				break;
			}

			}
		}

		List<List<Dictionary>> lists = new ArrayList<>();

		lists.add(OrderTypes);
		lists.add(OrderStates);
		lists.add(OrderdetailStates);
		lists.add(EquipmentNames);
		lists.add(EquipmentStates);
		lists.add(BusinessTypes);
		lists.add(BusinessWorkTypes);
		lists.add(BusinessStates);

		return lists;
	}

	@Override
	public void insertBusiness() {
		List<Equipment> equipments = equipmentService.select();
		for (Equipment equipment : equipments) {
			if (equipment.getSecexamtime() != null) {
				Date date = equipment.getSecexamtime();
				DateUtil dateUtil = new DateUtil(date);

				// 安检判断
				// equipment的安检时间减去7天后，如果在当前日期之前，说明要生成业务了
				// 此时查看是否有该equipment的的安检业务存在，且状态不为已完成（已完成的说明为以前安检过的记录）
				dateUtil.changeInstancedDate(null, null, -7);

				if (dateUtil.beforeTo(new Date())) {
					List<Business> businesses = businessService.getBusinessByequipmentIdAndType(equipment.getId(), "2");
					if (businesses.size() == 0) {
						Business business = new Business();
						business.setCreatetime(new Date());
						business.setEquipmentid(equipment.getId());
						business.setState("1");
						business.setType("2");
						businessService.insertByBusiness(business);
					} else {
						boolean bool = false;
						// 遍历看该改设备的安检事务是否存在，只要存在就break; 改bool=true；
						for (Business business : businesses) {

							if (!business.getState().equals("4")) {
								bool = true;
								break;
							}
						}
						// bool如果为false说明未存在该设备安检业务
						if (!bool) {
							Business business = new Business();
							business.setCreatetime(new Date());
							business.setEquipmentid(equipment.getId());
							business.setState("1");
							business.setType("2");
							businessService.insertByBusiness(business);
						}

					}
				}
			}

			if (equipment.getAnnualexamtime() != null) {
				Date date = equipment.getAnnualexamtime();
				DateUtil dateUtil = new DateUtil(date);

				// 年审判断
				// equipment的年审时间减去一年，加9个月，如果在当前日期之前，说明要生成业务了
				// 此时查看是否有该equipment的的安检业务存在，且状态不为已完成（已完成的说明为以前年审过的记录）
				dateUtil.changeInstancedDate(-1, 9, null);

				if (dateUtil.beforeTo(new Date())) {
					List<Business> businesses = businessService.getBusinessByequipmentIdAndType(equipment.getId(), "3");
					if (businesses.size() == 0) {
						Business business = new Business();
						business.setCreatetime(new Date());
						business.setEquipmentid(equipment.getId());
						business.setState("1");
						business.setType("3");
						businessService.insertByBusiness(business);
					} else {
						boolean bool = false;
						// 遍历看该改设备的安检事务是否存在，只要存在就break; 改bool=true；
						for (Business business : businesses) {

							if (!business.getState().equals("4")) {
								bool = true;
								break;
							}
						}
						// bool如果为false说明未存在该设备安检业务
						if (!bool) {
							Business business = new Business();
							business.setCreatetime(new Date());
							business.setEquipmentid(equipment.getId());
							business.setState("1");
							business.setType("3");
							businessService.insertByBusiness(business);
						}

					}
				}
			}

		}

	}

	@Override
	public List<RoleMenu> getMenuList(Integer roleId) {

		List<RoleMenu> roleMenus = roleMenuService.getMenuList(roleId);

		return roleMenus;
	}

}
