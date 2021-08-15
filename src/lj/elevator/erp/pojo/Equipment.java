package lj.elevator.erp.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Equipment {
	private Integer id;

	private String num;

	private Integer code;

	private String model;

	private String name;

	private String load;

	private BigDecimal speed;

	private String layerandstation;

	private String address;

	private Integer customerid;

	private String state;

	private Date scrapdate;

	private Date installtime;

	private Date opertime;

	private Date secexamtime;

	private Date annualexamtime;

	private Customer customer = new Customer();

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {

		this.customer = customer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num == null ? null : num.trim();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model == null ? null : model.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getLoad() {
		return load;
	}

	public void setLoad(String load) {
		this.load = load == null ? null : load.trim();
	}

	public BigDecimal getSpeed() {
		return speed;
	}

	public void setSpeed(BigDecimal speed) {
		this.speed = speed;
	}

	public String getLayerandstation() {
		return layerandstation;
	}

	public void setLayerandstation(String layerandstation) {
		this.layerandstation = layerandstation == null ? null : layerandstation.trim();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public Integer getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}

	public Date getScrapdate() {
		return scrapdate;
	}

	public void setScrapdate(Date scrapdate) {
		this.scrapdate = scrapdate;
	}

	public Date getInstalltime() {
		return installtime;
	}

	public void setInstalltime(Date installtime) {
		this.installtime = installtime;
	}

	public Date getOpertime() {
		return opertime;
	}

	public void setOpertime(Date opertime) {
		this.opertime = opertime;
	}

	public Date getSecexamtime() {
		return secexamtime;
	}

	public void setSecexamtime(Date secexamtime) {
		this.secexamtime = secexamtime;
	}

	public Date getAnnualexamtime() {
		return annualexamtime;
	}

	public void setAnnualexamtime(Date annualexamtime) {
		this.annualexamtime = annualexamtime;
	}
}