package lj.elevator.erp.pojo;

import java.math.BigDecimal;

public class Goodsprice {
	private Integer id;

	private BigDecimal inprice;

	private BigDecimal outprice;

	private Integer num;

	private Integer goodsid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getInprice() {
		return inprice;
	}

	public void setInprice(BigDecimal inprice) {
		this.inprice = inprice;
	}

	public BigDecimal getOutprice() {
		return outprice;
	}

	public void setOutprice(BigDecimal outprice) {
		this.outprice = outprice;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}
}