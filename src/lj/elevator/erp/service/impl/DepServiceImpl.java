package lj.elevator.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lj.elevator.erp.mapper.DepMapper;
import lj.elevator.erp.pojo.Dep;
import lj.elevator.erp.pojo.DepExample;
import lj.elevator.erp.pojo.DepExample.Criteria;
import lj.elevator.erp.service.DepService;

@Service
public class DepServiceImpl implements DepService {

	@Autowired
	private DepMapper depMapper;

	@Override
	public List<Dep> getDepByName(String depName) {
		DepExample depExample = new DepExample();
		if (depName != null) {
			Criteria criteriaD = depExample.createCriteria();

			criteriaD.andNameEqualTo(depName);
			List<Dep> deps = depMapper.selectByExample(depExample);

			return deps;
		}
		return null;

	}

	@Override
	public List<Dep> getDep() {

		List<Dep> deps = depMapper.select();

		return deps;
	}

	@Override
	public Dep geDepByKey(Integer id) {
		Dep dep = depMapper.selectByPrimaryKey(id);
		return dep;
	}

}
