package lj.elevator.erp.service;

import java.util.List;

import lj.elevator.erp.pojo.Business;
import lj.elevator.erp.pojo.Storedetail;

public interface NotesService {

	List<Business> getBusinessList(Integer id);

	List<Storedetail> getStoreAlertList();

}
