package lj.elevator.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lj.elevator.erp.mapper.StoreMapper;
import lj.elevator.erp.pojo.Store;
import lj.elevator.erp.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreMapper storeMapper;

	@Override
	public List<Store> getStore() {
		List<Store> stores = storeMapper.select();
		return stores;
	}

}
