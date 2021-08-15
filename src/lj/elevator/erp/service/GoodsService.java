package lj.elevator.erp.service;

import java.util.List;

import lj.elevator.erp.pojo.Goods;
import lj.elevator.erp.utils.Page;

public interface GoodsService {

	Page<Goods> getGoodsList(Page<Goods> page, String... targets) throws Exception;

	Page<Goods> saveGoods(Goods goods);

	Page<Goods> deleteGoodsById(Integer goodsId);

	List<String> getGoodsName();

	List<String> getGoodsNamebySuIdAndNameAndModel(Integer supplierId, String name, String model);

	Goods insertByOrderAdd(Goods goods);

	Goods getGoodsByNameAndModel(String name, String model);

	List<String> getGoodsNamebyNameAndModel(String name, String model);

	List<String> getGoodsNameBySupplierId(Integer supplierId);

	List<String> getGoodsModelNameBySupplierId(Integer supplierId);

	Goods getGoodsByKey(Integer id);

	void insert(String supplierName, Goods goods);

	int updateByPrimaryKey(Goods goods);

	List<Goods> getGoodsWitchAlertNumIsntNull();
}
