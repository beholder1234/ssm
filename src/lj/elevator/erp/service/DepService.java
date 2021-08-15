package lj.elevator.erp.service;

import java.util.List;

import lj.elevator.erp.pojo.Dep;

public interface DepService {

	public List<Dep> getDepByName(String depName);

	public List<Dep> getDep();

	public Dep geDepByKey(Integer id);

}
