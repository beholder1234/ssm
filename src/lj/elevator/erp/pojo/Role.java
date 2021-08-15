package lj.elevator.erp.pojo;

public class Role {
	private Integer id;

	private String name;

	private Integer depid;

	private Dep dep;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public Dep getDep() {
		return dep;
	}

	public void setDep(Dep dep) {
		this.dep = dep;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Integer getDepid() {
		return depid;
	}

	public void setDepid(Integer depid) {
		this.depid = depid;
	}
}