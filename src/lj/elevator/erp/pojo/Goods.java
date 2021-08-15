package lj.elevator.erp.pojo;

public class Goods {
	private Integer id;

	private String model;

	private String name;

	private String specs;

	private Integer supplierid;

	private String supplier;

	private Integer goodstypeid;

	private Integer alertnum;

	private String note;

	private String state;

	private String unit;

	private Goodstype goodstype = new Goodstype();

	public Integer getId() {
		return id;
	}

	public Goodstype getGoodstype() {
		return goodstype;
	}

	public void setGoodstype(Goodstype goodstype) {
		this.goodstype = goodstype;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getSpecs() {
		return specs;
	}

	public void setSpecs(String specs) {
		this.specs = specs == null ? null : specs.trim();
	}

	public Integer getSupplierid() {
		return supplierid;
	}

	public void setSupplierid(Integer supplierid) {
		this.supplierid = supplierid;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier == null ? null : supplier.trim();
	}

	public Integer getGoodstypeid() {
		return goodstypeid;
	}

	public void setGoodstypeid(Integer goodstypeid) {
		this.goodstypeid = goodstypeid;
	}

	public Integer getAlertnum() {
		return alertnum;
	}

	public void setAlertnum(Integer alertnum) {
		this.alertnum = alertnum;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note == null ? null : note.trim();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit == null ? null : unit.trim();
	}
}