package lj.elevator.erp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lj.elevator.erp.mapper.CustomerMapper;
import lj.elevator.erp.pojo.Customer;
import lj.elevator.erp.pojo.CustomerExample;
import lj.elevator.erp.pojo.CustomerExample.Criteria;
import lj.elevator.erp.pojo.Supplier;
import lj.elevator.erp.service.CustomerService;
import lj.elevator.erp.service.SupplierService;
import lj.elevator.erp.utils.ComServiceUtil;
import lj.elevator.erp.utils.Page;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;

	@Autowired
	private SupplierService supplierService;

	@Override
	public Page<Customer> getCustomerList(Page<Customer> page, String target) throws Exception {

		System.out.println("serviceImple In.......132" + customerMapper.getClass());

		ComServiceUtil<CustomerMapper, Customer> comServiceUtil = new ComServiceUtil<CustomerMapper, Customer>(
				customerMapper, page, target);

		page = comServiceUtil.getPage();

		System.out.println("serviceImple Out.......");

		return page;
	}

	@Override
	public Page<Customer> saveCustomer(Customer customer) {

		System.out.println("Tele:" + customer.getTele());
		customerMapper.updateByPrimaryKey(customer);

		Page<Customer> page = new Page<>();
		try {
			page = this.getCustomerList(null, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return page;

	}

	@Override
	public Page<Customer> deleteCustomerById(Integer customerId) {

		CustomerExample customerExample = new CustomerExample();
		Criteria criteria = customerExample.createCriteria();

		criteria.andIdEqualTo(customerId);

		Customer customer = new Customer();
		customer.setState("1");

		customerMapper.updateByExampleSelective(customer, customerExample);

		Page<Customer> page = new Page<>();

		try {
			page = this.getCustomerList(null, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return page;

	}

	@Override
	public Page<Customer> insert(Customer customer) {

		customerMapper.insertSelective(customer);

		Page<Customer> page = new Page<>();

		try {
			page = this.getCustomerList(null, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return page;
	}

	@Override
	public List<String> getSupplierName() {
		List<Supplier> suppliers = supplierService.getSupplier();
		List<String> list = new ArrayList<String>();
		for (Supplier supplier : suppliers) {
			list.add(supplier.getName());
		}

		return list;
	}

	@Override
	public List<String> getCustomerName() {

		List<Customer> customers = customerMapper.select();
		List<String> list = new ArrayList<>();

		for (Customer customer : customers) {

			list.add(customer.getName());

		}

		return list;
	}

	@Override
	public Customer insertByOrderAdd(Customer customer) {

		customer.setState("0");
		customerMapper.insertSelective(customer);

		return customer;
	}

	@Override
	public List<Customer> selectByNameAndContact(String name, String contact) {
		// 增获取storeNum

		CustomerExample cExample = new CustomerExample();

		Criteria criteria = cExample.createCriteria();
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
			List<Customer> customers = customerMapper.selectByExample(cExample);
			return customers;
		}

		return null;
	}

	@Override
	public Customer getCustomerByKey(Integer id) {

		Customer customer = customerMapper.selectByPrimaryKey(id);

		return customer;
	}
}
