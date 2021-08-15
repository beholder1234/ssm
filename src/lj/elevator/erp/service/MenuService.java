package lj.elevator.erp.service;

import java.util.List;

import lj.elevator.erp.pojo.Menu;

public interface MenuService {

	List<Menu> select();

	Menu selectByKey(Integer id);

}
