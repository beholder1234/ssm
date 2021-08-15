package lj.elevator.erp.pojo;

import java.util.List;

public class Dep {
	private Integer id;

	private String name;

	private String tele;

	private List<Role> roles;

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele == null ? null : tele.trim();
	}
}