package lj.elevator.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lj.elevator.erp.mapper.DictionaryMapper;
import lj.elevator.erp.pojo.Dictionary;
import lj.elevator.erp.service.DictionaryService;

@Service
public class DictionaryServiceImpl implements DictionaryService {

	@Autowired
	private DictionaryMapper dictionaryMapper;

	@Override
	public List<Dictionary> getDictionary() {

		List<Dictionary> dictionaries = dictionaryMapper.select();

		return dictionaries;
	}

}
