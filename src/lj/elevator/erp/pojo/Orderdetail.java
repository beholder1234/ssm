package lj.elevator.erp.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Orderdetail {
	private Integer id;

	private Integer goodsid;

	private BigDecimal price;

	private Integer num;

	private Date endtime;

	private String storekeeper;

	private Integer storeid;

	private Integer orderid;

	private String state;

	private Goods goods = new Goods();

	private Store store = new Store();

	public Goods getGoods() {
		return goods;
	}

	public Store getStore() {
		return store;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getStorekeeper() {
		return storekeeper;
	}

	public void setStorekeeper(String storekeeper) {
		this.storekeeper = storekeeper == null ? null : storekeeper.trim();
	}

	public Integer getStoreid() {
		return storeid;
	}

	public void setStoreid(Integer storeid) {
		this.storeid = storeid;
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