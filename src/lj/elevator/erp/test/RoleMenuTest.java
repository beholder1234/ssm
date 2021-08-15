package lj.elevator.erp.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lj.elevator.erp.mapper.RoleMenuMapper;

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration("classpath:spring/applicationContext-dao.xml")
@ContextConfiguration("classpath*:spring/applicationContext*.xml")
public class RoleMenuTest {

	@Autowired
	private RoleMenuMapper mapper;

	@Test
	public void getRoleMenuListTest() {

		mapper.getMenuList(1);
	}
}
