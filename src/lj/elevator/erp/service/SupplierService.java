package lj.elevator.erp.service;

import java.util.List;

import lj.elevator.erp.pojo.Supplier;
import lj.elevator.erp.utils.Page;

public interface SupplierService {

	Page<Supplier> getSupplierList(Page<Supplier> page, String target) throws Exception;

	Page<Supplier> saveSupplier(Supplier supplier);

	Page<Supplier> deleteSupplierById(Integer supplierId);

	Page<Supplier> insert(Supplier supplier);

	List<Supplier> getSupplier();

	List<Supplier> selectByName(String supplier);

	List<Supplier> selectByNameAndContact(String name, String contact);

	Supplier insertByOrderAdd(Supplier supplier);
}
