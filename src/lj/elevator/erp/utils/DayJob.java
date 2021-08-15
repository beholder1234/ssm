package lj.elevator.erp.utils;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lj.elevator.erp.pojo.Business;
import lj.elevator.erp.pojo.Equipment;
import lj.elevator.erp.service.BusinessService;
import lj.elevator.erp.service.EquipmentService;

/**
 * @author Beholder1234
 *
 *         每天均执行一次的任务
 */
@Service
public class DayJob {

	@Autowired
	private BusinessService businessService;

	@Autowired
	private EquipmentService equipmentService;

	// 每天任务运行的方法
	public void jobmethod() {
		System.out.println("Im IN My jOB");
		System.out.println("Im IN My jOB");
		System.out.println("Im IN My jOB");
		System.out.println("Im IN My jOB");
		insertBusiness();

	}

	private void insertBusiness() {
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
				dateUtil.changeInstancedDate(-1, 9, null); // 改 时间：2021-3-27
															// beholder1234
				// 原dateUtil.changeInstancedDate(-1, 3, null);

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
}
