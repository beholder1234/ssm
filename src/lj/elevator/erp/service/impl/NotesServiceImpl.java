package lj.elevator.erp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lj.elevator.erp.pojo.Business;
import lj.elevator.erp.pojo.Businessemprecord;
import lj.elevator.erp.pojo.Storedetail;
import lj.elevator.erp.service.BusinessService;
import lj.elevator.erp.service.BusinessemprecordService;
import lj.elevator.erp.service.GoodsService;
import lj.elevator.erp.service.NotesService;
import lj.elevator.erp.service.OrderService;
import lj.elevator.erp.service.StoredetailService;

@Service
public class NotesServiceImpl implements NotesService {

	@Autowired
	private BusinessemprecordService bemprecordService;

	@Autowired
	private BusinessService businessService;

	@Autowired
	private StoredetailService sdService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private GoodsService goodsService;

	@Override
	public List<Business> getBusinessList(Integer id) {

		List<Businessemprecord> records = bemprecordService.selectByEmpId(id);

		List<Business> businesses = new ArrayList<Business>();
		for (Businessemprecord record : records) {

			Business business = businessService.getBusinessdetailList(record.getBusinessid());

			if (business.getState().equals("1") || business.getState().equals("2") || business.getState().equals("3")) {

				businesses.add(business);
			}

		}

		return businesses;
	}

	@Override
	public List<Storedetail> getStoreAlertList() {

		List<Storedetail> storedetails = sdService.getStoreAlertList();

		return storedetails;
	}

	private List<Integer[]> getOrderGoodsIdAndNum() {

		List<Integer> goodsIds = orderService.selectSameGoodsIdForNotes();

		List<Integer> goodsNum = orderService.selectSameGoodsNumForNotes();

		List<Integer[]> data = new ArrayList<>();

		for (int i = 0; i < goodsIds.size(); i++) {
			Integer[] integers = { goodsIds.get(i), goodsNum.get(i) };
			data.add(integers);
		}

		return data;
	}

}
