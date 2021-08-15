package lj.elevator.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import lj.elevator.erp.pojo.Goods;
import lj.elevator.erp.service.GoodsService;
import lj.elevator.erp.utils.Page;

@Controller
@SessionAttributes(value = { "page" })
public class GoodsController {

	@Autowired
	private GoodsService goodsService;

	@RequestMapping("goodsList")
	public String goodsList(Page<Goods> page, String goodsTypeS, String supplierS, String goodsNameS, Model model)
			throws Exception {
		System.out.println(goodsTypeS == null);
		page = goodsService.getGoodsList(page, goodsTypeS, supplierS, goodsNameS);

		model.addAttribute("page", page);

		return "/jsp/goods_list.jsp";
	}

	@RequestMapping("goodsList2")
	public String goodsList2(Page<Goods> page, String goodsTypeS, String supplierS, String goodsNameS, Model model)
			throws Exception {
		System.out.println(goodsTypeS == null);
		page = goodsService.getGoodsList(page, goodsTypeS, supplierS, goodsNameS);

		model.addAttribute("page", page);

		return "/jsp/goods2_list.jsp";
	}

	@RequestMapping("getGoods")
	public @ResponseBody Goods getGoods(Page<Goods> page, Integer goodsId) {

		System.out.println(goodsId);
		List<Goods> goods = page.getRows();
		for (Goods goods2 : goods) {
			if (goods2.getId().equals(goodsId)) {
				System.out.println(goods2.getId());
				return goods2;
			}
		}

		return null;

	}

	@RequestMapping("saveGoods")
	public String saveGoods(Goods goods, Model model) {

		System.out.println(goods.getModel());
		System.out.println(goods.getGoodstype().getName());
		Page<Goods> page = goodsService.saveGoods(goods);

		model.addAttribute("page", page);

		return "/jsp/goods_list.jsp";

	}

	@RequestMapping("deleteGoodsById")
	public @ResponseBody void deleteGoodsById(Integer goodsId, Model model) {

		Page<Goods> page = goodsService.deleteGoodsById(goodsId);

		model.addAttribute("page", page);

		return;

	}

	@RequestMapping("getGoodsName")
	public @ResponseBody List<String> getGoodsName() {

		List<String> list = goodsService.getGoodsName();

		return list;

	}

	@RequestMapping("getGoodsNameBySupplierId")
	public @ResponseBody List<String> getGoodsNameBySupplierId(Integer supplierId) {

		List<String> list = goodsService.getGoodsNameBySupplierId(supplierId);
		return list;

	}

	@RequestMapping("getGoodsModelNameBySupplierId")
	public @ResponseBody List<String> getGoodsModelNameBySupplierId(Integer supplierId) {

		List<String> list = goodsService.getGoodsModelNameBySupplierId(supplierId);
		return list;

	}

	@RequestMapping("insertGoods")
	public String insertGoods(String supplierName, Goods goods) {

		goodsService.insert(supplierName, goods);

		return "jsp/goods_add.jsp";
	}

	@RequestMapping("goodsAddList")
	public String goodsAddList() {

		return "jsp/goods_add.jsp";

	}

	@RequestMapping("insertGoodsByAddOrder")
	public @ResponseBody Goods insertGoodsByAddOrder(Goods goods) {

		goods = goodsService.insertByOrderAdd(goods);

		return goods;
	}
}
