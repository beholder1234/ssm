package lj.elevator.erp.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lj.elevator.erp.mapper.RoleMapper;
import lj.elevator.erp.pojo.Role;

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration("classpath:spring/applicationContext-dao.xml")
@ContextConfiguration("classpath*:spring/applicationContext*.xml")
public class roletest {

	@Autowired
	private RoleMapper roleMapper;

	@Test
	public void selectTest() {

		List<Role> roles = roleMapper.select();
		System.out.println(roles.get(0).getDep().getName());
	}
}
