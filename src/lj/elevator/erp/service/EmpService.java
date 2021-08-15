package lj.elevator.erp.service;

import java.util.List;

import lj.elevator.erp.pojo.Emp;
import lj.elevator.erp.utils.Page;

public interface EmpService {
	public List<Emp> getEmpById(Integer id);

	public Page<Emp> getEmpList(Page<Emp> page, String target) throws Exception;

	public Page<Emp> saveEmp(Page<Emp> page, Integer empId, String tele, String email, String depName, String roleName);

	public Page<Emp> deleteEmpById(Page<Emp> page, Integer empId);

	public Page<Emp> insertEmp(Page<Emp> page, Emp emp);

	public List<Emp> select();

	public List<String> getEmpName();

	public Emp getEmpByName(String name);

	public Emp selectEmpById(Integer checkerId);

	public List<String> getUsername();

	public void insertEmp(Emp emp, Integer roleid);

	public void resetPwd(Integer id);

	public boolean changePwd(Emp oneRole, String originPwd, String newPwd, String newPwd2);

}
