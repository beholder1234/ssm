package lj.elevator.erp.pojo;

import java.util.ArrayList;
import java.util.List;

public class Storedetail {
	private Integer id;

	private Integer storeid;

	private Integer goodsid;

	private Integer supplierid;

	private Integer totalnum;

	private Goods goods = new Goods();

	private Supplier supplier = new Supplier();

	private Store store = new Store();

	private List<Goodsprice> goodsprices = new ArrayList<Goodsprice>();

	public Integer getId() {
		return id;
	}

	public Goods getGoods() {
		return goods;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public Store getStore() {
		return store;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public List<Goodsprice> getGoodsprices() {
		return goodsprices;
	}

	public void setGoodsprices(List<Goodsprice> goodsprices) {
		this.goodsprices = goodsprices;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStoreid() {
		return storeid;
	}

	public void setStoreid(Integer storeid) {
		this.storeid = storeid;
	}

	public Integer getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}

	public Integer getSupplierid() {
		return supplierid;
	}

	public void setSupplierid(Integer supplierid) {
		this.supplierid = supplierid;
	}

	public Integer getTotalnum() {
		return totalnum;
	}

	public void setTotalnum(Integer totalnum) {
		this.totalnum = totalnum;
	}
}