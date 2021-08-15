package lj.elevator.erp.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Business {
	private Integer id;

	private String type;

	private Integer equipmentid;

	private Date createtime;

	private Date starttime;

	private Date endtime;

	private Integer orderid;

	private String state;

	private Equipment equipment = new Equipment();

	private List<Businessemprecord> businessemprecords = new ArrayList<Businessemprecord>();

	public List<Businessemprecord> getBusinessemprecords() {
		return businessemprecords;
	}

	public void setBusinessemprecords(List<Businessemprecord> businessemprecords) {
		this.businessemprecords = businessemprecords;

	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public Integer getEquipmentid() {
		return equipmentid;
	}

	public void setEquipmentid(Integer equipmentid) {
		this.equipmentid = equipmentid;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}
}