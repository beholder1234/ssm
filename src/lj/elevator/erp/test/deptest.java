package lj.elevator.erp.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lj.elevator.erp.mapper.DepMapper;
import lj.elevator.erp.pojo.Dep;

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration("classpath:spring/applicationContext-dao.xml")
@ContextConfiguration("classpath*:spring/applicationContext*.xml")
public class deptest {

	@Autowired
	private DepMapper depMapper;

	@Test
	public void selectAll() {

		List<Dep> deps = depMapper.select();

		System.out.println(deps.get(2).getRoles().size());
	}

}
