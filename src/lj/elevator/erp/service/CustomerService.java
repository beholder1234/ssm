package lj.elevator.erp.service;

import java.util.List;

import lj.elevator.erp.pojo.Customer;
import lj.elevator.erp.utils.Page;

public interface CustomerService {

	public Page<Customer> getCustomerList(Page<Customer> page, String target) throws Exception;

	public Page<Customer> saveCustomer(Customer customer);

	public Page<Customer> deleteCustomerById(Integer customerId);

	public Page<Customer> insert(Customer customer);

	public List<String> getSupplierName();

	public List<String> getCustomerName();

	public Customer insertByOrderAdd(Customer customer);

	public List<Customer> selectByNameAndContact(String name, String contact);

	public Customer getCustomerByKey(Integer id);

}
