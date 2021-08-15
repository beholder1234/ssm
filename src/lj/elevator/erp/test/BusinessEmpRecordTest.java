package lj.elevator.erp.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lj.elevator.erp.mapper.BusinessemprecordMapper;
import lj.elevator.erp.pojo.Businessemprecord;

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration("classpath:spring/applicationContext-dao.xml")
@ContextConfiguration("classpath*:spring/applicationContext*.xml")
public class BusinessEmpRecordTest {

	@Autowired
	private BusinessemprecordMapper mapper;

	@Test
	public void selectByBusinessId() {
		List<Businessemprecord> businessemprecord = mapper.selectByBusinessId(1);

		// System.out.println(businessemprecord.get(0).getEmp().getName());
	}

	// @Test
	public void selectByEmpId() {
		List<Businessemprecord> businessemprecord = mapper.selectByEmpId(1);

	}
}
