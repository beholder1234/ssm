package lj.elevator.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lj.elevator.erp.mapper.EmpRoleMapper;
import lj.elevator.erp.pojo.EmpRole;
import lj.elevator.erp.pojo.EmpRoleExample;
import lj.elevator.erp.pojo.EmpRoleExample.Criteria;
import lj.elevator.erp.service.EmpRoleService;

@Service
public class EmpRoleServiceImpl implements EmpRoleService {

	@Autowired
	private EmpRoleMapper empRoleMapper;

	@Override
	public void updateEmpRoleByFkeyAndNewRole(Integer empId, Integer roleId, Integer newRoleId) {
		EmpRoleExample empRoleExample = new EmpRoleExample();
		Criteria criteria = empRoleExample.createCriteria();

		if (newRoleId == null) {
			return;
		} else if (roleId == null) {

			insertEmpRole(empId, newRoleId);

		} else {
			List<EmpRole> empRoles = selectEmpRoleByRoleId(empId, roleId);
			empRoles.get(0).setRoleid(newRoleId);
			criteria.andEmpidEqualTo(empId);
			criteria.andRoleidEqualTo(roleId);

			empRoleMapper.updateByExample(empRoles.get(0), empRoleExample);

		}

	}

	public List<EmpRole> selectEmpRoleByRoleId(Integer empId, Integer roleId) {
		EmpRoleExample empRoleExample = new EmpRoleExample();

		Criteria criteria = empRoleExample.createCriteria();

		criteria.andEmpidEqualTo(empId);
		criteria.andRoleidEqualTo(roleId);

		List<EmpRole> empRoles = empRoleMapper.selectByExample(empRoleExample);

		return empRoles;
	}

	public void insertEmpRole(Integer empId, Integer roleId) {

		EmpRole empRole = new EmpRole();
		empRole.setEmpid(empId);
		empRole.setRoleid(roleId);

		empRoleMapper.insert(empRole);

	}

	@Override
	public Integer getRoleIdByEmpId(Integer empid) {

		EmpRoleExample empRoleExample = new EmpRoleExample();

		Criteria criteria = empRoleExample.createCriteria();

		criteria.andEmpidEqualTo(empid);

		List<EmpRole> empRoles = empRoleMapper.selectByExample(empRoleExample);
		if (empRoles.size() != 0) {

			return empRoles.get(0).getRoleid();
		}
		return null;
	}

}
