package lj.elevator.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lj.elevator.erp.mapper.SupplierMapper;
import lj.elevator.erp.pojo.Supplier;
import lj.elevator.erp.pojo.SupplierExample;
import lj.elevator.erp.pojo.SupplierExample.Criteria;
import lj.elevator.erp.service.SupplierService;
import lj.elevator.erp.utils.ComServiceUtil;
import lj.elevator.erp.utils.Page;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierMapper supplierMapper;

	@Override
	public Page<Supplier> getSupplierList(Page<Supplier> page, String target) throws Exception {

		System.out.println("serviceImple In.......");

		ComServiceUtil<SupplierMapper, Supplier> comServiceUtil = new ComServiceUtil<SupplierMapper, Supplier>(
				supplierMapper, page, target);

		page = comServiceUtil.getPage();

		System.out.println("serviceImple Out.......");

		return page;
	}

	@Override
	public Page<Supplier> saveSupplier(Supplier supplier) {

		System.out.println("Tele:" + supplier.getTele());
		supplierMapper.updateByPrimaryKey(supplier);

		Page<Supplier> page = new Page<>();
		try {
			page = this.getSupplierList(null, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return page;

	}

	@Override
	public Page<Supplier> deleteSupplierById(Integer supplierId) {

		SupplierExample supplierExample = new SupplierExample();
		Criteria criteria = supplierExample.createCriteria();

		criteria.andIdEqualTo(supplierId);

		Supplier supplier = new Supplier();
		supplier.setState("1");

		supplierMapper.updateByExampleSelective(supplier, supplierExample);

		Page<Supplier> page = new Page<>();

		try {
			page = this.getSupplierList(null, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return page;

	}

	@Override
	public Page<Supplier> insert(Supplier supplier) {

		supplierMapper.insertSelective(supplier);

		Page<Supplier> page = new Page<>();

		try {
			page = this.getSupplierList(null, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return page;
	}

	@Override
	public List<Supplier> getSupplier() {

		List<Supplier> suppliers = supplierMapper.select();
		return suppliers;
	}

	@Override
	public List<Supplier> selectByName(String supplier) {

		SupplierExample supplierExample = new SupplierExample();

		Criteria criteria = supplierExample.createCriteria();

		criteria.andNameEqualTo(supplier);

		List<Supplier> suppliers = supplierMapper.selectByExample(supplierExample);

		return suppliers;
	}

	@Override
	public List<Supplier> selectByNameAndContact(String name, String contact) {

		SupplierExample supplierExample = new SupplierExample();

		Criteria criteria = supplierExample.createCriteria();
		boolean conditionExist = false;
		if (name != null) {
			name = name.replace(" ", "");
			if (name != "") {
				criteria.andNameEqualTo(name);
				conditionExist = true;
			}
		}

		if (contact != null) {
			contact = contact.replace(" ", "");
			if (contact != "") {
				criteria.andContactEqualTo(contact);
				conditionExist = true;
			}
		}

		if (conditionExist) {
			List<Supplier> suppliers = supplierMapper.selectByExample(supplierExample);
			return suppliers;
		}

		return null;

	}

	@Override
	public Supplier insertByOrderAdd(Supplier supplier) {
		supplier.setState("0");
		supplierMapper.insertSelective(supplier);
		return supplier;
	}
}
