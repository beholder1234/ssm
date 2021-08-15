package lj.elevator.erp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lj.elevator.erp.mapper.StoredetailMapper;
import lj.elevator.erp.pojo.Goodsprice;
import lj.elevator.erp.pojo.Order;
import lj.elevator.erp.pojo.Orderdetail;
import lj.elevator.erp.pojo.Storedetail;
import lj.elevator.erp.pojo.StoredetailExample;
import lj.elevator.erp.pojo.StoredetailExample.Criteria;
import lj.elevator.erp.service.GoodspriceService;
import lj.elevator.erp.service.StoredetailService;
import lj.elevator.erp.utils.ComServiceUtil;
import lj.elevator.erp.utils.Page;

@Service
public class StoredetailServiceImpl implements StoredetailService {

	@Autowired
	private StoredetailMapper storedetailMapper;

	@Autowired
	private GoodspriceService goodspriceService;

	@Override
	public Page<Storedetail> getStoredetailList(Page<Storedetail> page, String[] targets) throws Exception {
		System.out.println("serviceImple In.......");

		ComServiceUtil<StoredetailMapper, Storedetail> comServiceUtil = new ComServiceUtil<StoredetailMapper, Storedetail>(
				storedetailMapper, page, targets);
		// 获取封装的数据
		page = comServiceUtil.getPage();

		page = this.setGoodsprice(page);

		System.out.println("serviceImple Out.......");
		return page;
	}

	private Page<Storedetail> setGoodsprice(Page<Storedetail> page) {

		List<Storedetail> list = page.getRows();
		ArrayList<Storedetail> newlist = new ArrayList<Storedetail>();
		for (Storedetail storedetail : list) {
			Integer id = storedetail.getId();

			List<Goodsprice> goodsprices = goodspriceService.selectGoodspriceByGoodId(id);

			storedetail.setGoodsprices(goodsprices);

			newlist.add(storedetail);
		}

		page.setRows(newlist);

		return page;
	}

	@Override
	public void insertStore(Order order, Orderdetail orderdetail) {

		System.out.println("insertStore Start");
		StoredetailExample storedetailExample = new StoredetailExample();
		Criteria criteria = storedetailExample.createCriteria();

		criteria.andStoreidEqualTo(orderdetail.getStoreid());
		criteria.andGoodsidEqualTo(orderdetail.getGoodsid());
		criteria.andSupplieridEqualTo(order.getSupplierid());

		List<Storedetail> storedetails = storedetailMapper.selectByExample(storedetailExample);

		if (storedetails.size() != 0) {
			System.out.println("insertStore update..... ");
			Storedetail storedetail = storedetails.get(0);
			Integer num = storedetail.getTotalnum();
			num = orderdetail.getNum() + num;
			storedetail.setTotalnum(num);
			storedetailMapper.updateByPrimaryKey(storedetail);
		} else {
			System.out.println("insertStore insert..... ");

			Storedetail storedetail = new Storedetail();
			storedetail.setStoreid(orderdetail.getStoreid());
			storedetail.setGoodsid(orderdetail.getGoodsid());
			storedetail.setSupplierid(order.getSupplierid());
			storedetail.setTotalnum(orderdetail.getNum());
			storedetailMapper.insertSelective(storedetail);
		}
	}

	@Override
	public void outputStore(Order order, Orderdetail orderdetail) {

		System.out.println("outputStore Start");
		StoredetailExample storedetailExample = new StoredetailExample();
		Criteria criteria = storedetailExample.createCriteria();

		criteria.andStoreidEqualTo(orderdetail.getStoreid());
		criteria.andGoodsidEqualTo(orderdetail.getGoodsid());
		criteria.andSupplieridEqualTo(order.getSupplierid());

		List<Storedetail> storedetails = storedetailMapper.selectByExample(storedetailExample);

		if (storedetails.size() != 0) {
			System.out.println("outputStore update..... ");
			Storedetail storedetail = storedetails.get(0);
			Integer num = storedetail.getTotalnum();
			num = num - orderdetail.getNum();
			storedetail.setTotalnum(num);
			storedetailMapper.updateByPrimaryKey(storedetail);
		} else {
			System.out.println("仓库未找到该商品");
		}
	}

	@Override
	public Storedetail getStoredetailByGoodsId(Integer goodsid) {
		StoredetailExample sExample = new StoredetailExample();
		Criteria criteria = sExample.createCriteria();

		criteria.andGoodsidEqualTo(goodsid);

		List<Storedetail> storedetails = storedetailMapper.selectByExample(sExample);
		if (storedetails.size() != 0) {
			return storedetails.get(0);
		}
		return null;
	}

	@Override
	public List<Storedetail> getStoreAlertList() {

		List<Storedetail> storedetail = storedetailMapper.getStoreAlertList();

		return storedetail;
	}
}
