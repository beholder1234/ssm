package lj.elevator.erp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lj.elevator.erp.mapper.EmpMapper;
import lj.elevator.erp.pojo.Dep;
import lj.elevator.erp.pojo.Emp;
import lj.elevator.erp.pojo.EmpExample;
import lj.elevator.erp.pojo.EmpExample.Criteria;
import lj.elevator.erp.pojo.Role;
import lj.elevator.erp.service.DepService;
import lj.elevator.erp.service.EmpRoleService;
import lj.elevator.erp.service.EmpService;
import lj.elevator.erp.service.RoleService;
import lj.elevator.erp.utils.ComServiceUtil;
import lj.elevator.erp.utils.EmailUtil;
import lj.elevator.erp.utils.MD5Utils;
import lj.elevator.erp.utils.Page;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpMapper empMapper;

	@Autowired
	private DepService depService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private EmpRoleService empRoleService;

	@Override
	public List<Emp> getEmpById(Integer id) {

		EmpExample empExample = new EmpExample();
		Criteria criteria = empExample.createCriteria();

		criteria.andIdEqualTo(id);

		List<Emp> emps = empMapper.selectByExample(empExample);

		return emps;
	}

	@Override
	public Page<Emp> getEmpList(Page<Emp> page, String target) throws Exception {

		System.out.println("serviceImple In.......");

		ComServiceUtil<EmpMapper, Emp> comServiceUtil = new ComServiceUtil<EmpMapper, Emp>(empMapper, page, target);
		// 获取封装的数据
		page = comServiceUtil.getPage();

		System.out.println("serviceImple Out.......");
		return page;
	}

	@Override
	public Page<Emp> saveEmp(Page<Emp> page, Integer empId, String tele, String email, String depName,
			String roleName) {
		EmpExample empExample = new EmpExample();
		for (Emp emp : page.getRows()) {
			if (emp.getId().equals(empId)) {
				System.out.println("Service  saveEmp In....");
				List<Dep> deps = depService.getDepByName(depName);

				List<Role> roles = roleService.getRoleByName(roleName);
				System.out.println("Service updateEmpRole In...");
				if (roles.size() == 0) {
					empRoleService.updateEmpRoleByFkeyAndNewRole(emp.getId(), emp.getRole().getId(), null);
				} else {
					empRoleService.updateEmpRoleByFkeyAndNewRole(emp.getId(), emp.getRole().getId(),
							roles.get(0).getId());

				}

				Criteria criteria = empExample.createCriteria();

				emp.setTele(tele);
				emp.setEmail(email);
				if (deps.size() != 0) {
					emp.setDepid(deps.get(0).getId());
				}

				criteria.andIdEqualTo(emp.getId());

				System.out.println("Service update Emp  In....." + emp.getTele());
				empMapper.updateByExampleSelective(emp, empExample);

				try {
					System.out.println("Service getEmpList In....");
					Page<Emp> page2 = getEmpList(page, null);
					return page2;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Service Catch worry......");
					e.printStackTrace();
				}

			}
		}
		return page;
	}

	@Override
	public Page<Emp> deleteEmpById(Page<Emp> page, Integer empId) {

		for (Emp emp : page.getRows()) {
			if (emp.getId().equals(empId)) {

				empMapper.deleteById(empId);

			}

		}

		try {
			return this.getEmpList(page, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Page<Emp> insertEmp(Page<Emp> page, Emp emp) {

		try {
			return this.getEmpList(page, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public List<Emp> select() {

		List<Emp> emps = empMapper.select();
		return emps;
	}

	@Override
	public List<String> getEmpName() {

		List<Emp> list = this.select();

		List<String> empName = new ArrayList<String>();

		for (Emp emp : list) {
			empName.add(emp.getName());
		}

		return empName;
	}

	@Override
	public Emp getEmpByName(String name) {

		EmpExample empExample = new EmpExample();
		Criteria criteria = empExample.createCriteria();

		if (name != null) {
			name = name.replace(" ", "");
			if (name != "") {
				criteria.andNameEqualTo(name);
				List<Emp> emps = empMapper.selectByExample(empExample);

				// 因control只取第一个emp，所以只对第一个emp进行部门，角色赋值
				if (emps.size() != 0) {
					Emp emp = emps.get(0);
					Dep dep = depService.geDepByKey(emp.getDepid());
					Role role = roleService.getRoleByEmpId(emp.getId());
					if (dep != null) {
						emp.setDep(dep);
					}
					if (role != null) {
						emp.setRole(role);

					}
					return emp;
				}

			}
		}

		return null;

	}

	@Override
	public Emp selectEmpById(Integer checkerId) {
		Emp emp = empMapper.selectByPrimaryKey(checkerId);
		return emp;
	}

	@Override
	public List<String> getUsername() {

		List<Emp> emps = empMapper.select();

		List<String> list = new ArrayList<String>();

		for (Emp emp : emps) {
			if (emp.getUsername() != null) {
				list.add(emp.getUsername());
			}
		}

		return list;
	}

	@Override
	public void insertEmp(Emp emp, Integer roleid) {

		emp.setPwd(MD5Utils.encrypt("123456"));
		emp.setState("0");

		empMapper.insertSelective(emp);

		empRoleService.insertEmpRole(emp.getId(), roleid);
	}

	@Override
	public void resetPwd(Integer id) {
		Emp emp = empMapper.selectByPrimaryKey(id);

		emp.setPwd(MD5Utils.encrypt("123456"));

		if (emp.getEmail() != null) {
			EmailUtil eUtil = new EmailUtil(emp.getEmail());
			eUtil.resetPwdMail();
		}

		empMapper.updateByPrimaryKey(emp);
	}

	@Override
	public boolean changePwd(Emp oneRole, String originPwd, String newPwd, String newPwd2) {

		System.out.println("测 MD5Utils...");
		// oneRole 设为了session ，但不知为什么找不到，所以改为 从shiro中招当前emp对象
		// 密码改完后要从新登陆，所以只需该数据库信息就可，session对象和shiro对象的密码数据不用改
		Emp emp = (Emp) SecurityUtils.getSubject().getPrincipal();

		if (emp.getPwd().equals(MD5Utils.encrypt(originPwd)) && newPwd.equals(newPwd2)) {

			System.out.println("change ....");
			emp.setPwd(MD5Utils.encrypt(newPwd));
			empMapper.updateByPrimaryKey(emp);
			return true;
		}

		return false;
	}

}
