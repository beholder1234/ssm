package lj.elevator.erp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lj.elevator.erp.mapper.GoodsMapper;
import lj.elevator.erp.pojo.Goods;
import lj.elevator.erp.pojo.GoodsExample;
import lj.elevator.erp.pojo.GoodsExample.Criteria;
import lj.elevator.erp.pojo.Goodstype;
import lj.elevator.erp.pojo.Supplier;
import lj.elevator.erp.service.GoodsService;
import lj.elevator.erp.service.GoodsTypeService;
import lj.elevator.erp.service.StoredetailService;
import lj.elevator.erp.service.SupplierService;
import lj.elevator.erp.utils.ComServiceUtil;
import lj.elevator.erp.utils.Page;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;

	@Autowired
	private GoodsTypeService gTypeService;

	@Autowired
	private SupplierService supplierService;

	@Autowired
	private StoredetailService storedetailService;

	@Override
	public Page<Goods> getGoodsList(Page<Goods> page, String... targets) throws Exception {

		ComServiceUtil<GoodsMapper, Goods> comServiceUtil = new ComServiceUtil<GoodsMapper, Goods>(goodsMapper, page,
				targets);

		page = comServiceUtil.getPage();
		return page;
	}

	@Override
	public Page<Goods> saveGoods(Goods goods) {

		List<Goodstype> goodstypes = gTypeService.selectByName(goods.getGoodstype().getName());

		goods.setGoodstypeid(goodstypes.get(0).getId());

		List<Supplier> suppliers = supplierService.selectByName(goods.getSupplier());

		goods.setSupplierid(suppliers.get(0).getId());

		goodsMapper.updateByPrimaryKeySelective(goods);

		Page<Goods> page = new Page<>();
		try {
			page = this.getGoodsList(null, new String[] { null, null, null });
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return page;
	}

	@Override
	public Page<Goods> deleteGoodsById(Integer goodsId) {

		goodsMapper.deleteGoodsById(goodsId);

		Page<Goods> page = new Page<>();
		try {
			page = this.getGoodsList(null, null, null, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return page;

	}

	@Override
	public List<String> getGoodsName() {

		List<String> goodsNames = goodsMapper.selectName();

		return goodsNames;

	}

	@Override
	public List<String> getGoodsNamebySuIdAndNameAndModel(Integer supplierId, String name, String model) {

		GoodsExample gExample = new GoodsExample();

		Criteria criteria = gExample.createCriteria();

		criteria.andSupplieridEqualTo(supplierId);

		if (name != null) {
			name = name.replace(" ", "");
			if (name != "") {
				criteria.andNameEqualTo(name);

			}
		}
		if (model != null) {
			model = model.replace(" ", "");
			if (model != "") {
				criteria.andNameEqualTo(model);

			}
		}

		List<Goods> goods = goodsMapper.selectByExample(gExample);

		List<String> list = new ArrayList<String>();

		for (Goods goods2 : goods) {
			if (list.indexOf(goods2.getName()) == -1) {
				list.add(goods2.getName());
			}

		}
		return list;
	}

	@Override
	public Goods insertByOrderAdd(Goods goods) {
		goods.setState("0");

		goodsMapper.insertSelective(goods);

		return goods;
	}

	@Override
	public Goods getGoodsByNameAndModel(String name, String model) {

		GoodsExample goodsExample = new GoodsExample();

		Criteria criteria = goodsExample.createCriteria();

		if (name != null) {
			name = name.replace(" ", "");
			if (name != "") {
				criteria.andNameEqualTo(name);
			}

		}

		if (model != null) {
			model = model.replace(" ", "");
			if (model != "") {
				criteria.andModelEqualTo(model);
			}

		}

		List<Goods> goods = goodsMapper.selectByExample(goodsExample);

		if (goods.size() != 0) {
			Goodstype goodstype = gTypeService.getGoodsTypeById(goods.get(0).getGoodstypeid());

			Goods goods2 = goods.get(0);
			goods2.setGoodstype(goodstype);

			/*
			 * Storedetail storedetail =
			 * storedetailService.getStoredetailByGoodsId(goods2.getId());
			 * 
			 * if (storedetail == null) { Storedetail storedetail2 = new
			 * Storedetail(); storedetail2.setTotalnum(0);
			 * goods2.setStoredetail(storedetail2); } else {
			 * 
			 * goods2.setStoredetail(storedetail); }
			 */

			return goods2;
		}

		return null;
	}

	@Override
	public List<String> getGoodsNamebyNameAndModel(String name, String model) {

		GoodsExample gExample = new GoodsExample();

		Criteria criteria = gExample.createCriteria();

		if (name != null) {
			name = name.replace(" ", "");
			if (name != "") {
				criteria.andNameEqualTo(name);

			}
		}
		if (model != null) {
			model = model.replace(" ", "");
			if (model != "") {
				criteria.andNameEqualTo(model);

			}
		}

		List<Goods> goods = goodsMapper.selectByExample(gExample);

		List<String> list = new ArrayList<String>();

		for (Goods goods2 : goods) {
			if (list.indexOf(goods2.getName()) == -1) {
				list.add(goods2.getName());
			}

		}
		return list;
	}

	@Override
	public List<String> getGoodsNameBySupplierId(Integer supplierId) {

		if (supplierId == null) {
			return this.getGoodsName();
		} else {
			GoodsExample gExample = new GoodsExample();
			Criteria criteria = gExample.createCriteria();
			criteria.andSupplieridEqualTo(supplierId);
			List<Goods> goods = goodsMapper.selectByExample(gExample);
			List<String> list = new ArrayList<>();
			for (Goods goods2 : goods) {
				list.add(goods2.getName());
			}

			return list;

		}

	}

	@Override
	public List<String> getGoodsModelNameBySupplierId(Integer supplierId) {

		if (supplierId == null) {
			List<String> list = goodsMapper.selectModelName();
			return list;
		} else {
			List<String> list = goodsMapper.selectModelNameBySupplierId(supplierId);

			return list;

		}

	}

	@Override
	public Goods getGoodsByKey(Integer id) {

		Goods goods = goodsMapper.selectByPrimaryKey(id);
		return goods;
	}

	@Override
	public void insert(String supplierName, Goods goods) {

		List<Supplier> suppliers = supplierService.selectByName(supplierName);
		goods.setSupplier(supplierName);
		goods.setSupplierid(suppliers.get(0).getId());
		goodsMapper.insertSelective(goods);

	}

	@Override
	public int updateByPrimaryKey(Goods goods) {
		goodsMapper.updateByPrimaryKey(goods);
		return 0;
	}

	@Override
	public List<Goods> getGoodsWitchAlertNumIsntNull() {
		GoodsExample gExample = new GoodsExample();

		Criteria criteria = gExample.createCriteria();

		criteria.andAlertnumGreaterThan(0);

		List<Goods> goods = goodsMapper.selectByExample(gExample);
		return goods;

	}

}
