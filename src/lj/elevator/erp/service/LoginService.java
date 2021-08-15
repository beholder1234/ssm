package lj.elevator.erp.service;

import java.util.List;
import java.util.Map;

import lj.elevator.erp.pojo.RoleMenu;

public interface LoginService {

	Map<String, Object> getLoadInDate();

	void insertBusiness();

	List<RoleMenu> getMenuList(Integer empId);

}
