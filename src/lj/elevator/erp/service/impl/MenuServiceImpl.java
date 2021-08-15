package lj.elevator.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lj.elevator.erp.mapper.MenuMapper;
import lj.elevator.erp.pojo.Menu;
import lj.elevator.erp.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menuMapper;

	@Override
	public List<Menu> select() {
		List<Menu> list = menuMapper.select();
		return list;
	}

	@Override
	public Menu selectByKey(Integer id) {
		Menu menu = menuMapper.selectByPrimaryKey(id);
		return menu;
	}

}
