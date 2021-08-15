package lj.elevator.erp.service;

import java.util.List;

import lj.elevator.erp.pojo.EmpRole;

public interface EmpRoleService {

	void updateEmpRoleByFkeyAndNewRole(Integer empId, Integer roleId, Integer newRoleId);

	public List<EmpRole> selectEmpRoleByRoleId(Integer empId, Integer roleId);

	public void insertEmpRole(Integer empId, Integer roleId);

	Integer getRoleIdByEmpId(Integer empid);
}
