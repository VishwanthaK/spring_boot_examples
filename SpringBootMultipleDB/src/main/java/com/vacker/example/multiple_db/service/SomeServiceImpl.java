package com.vacker.example.multiple_db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacker.example.multiple_db.domain.primary.PrimaryTable1;
import com.vacker.example.multiple_db.domain.primary.PrimaryTable1Repository;
import com.vacker.example.multiple_db.domain.secondary.SecondaryTable1;
import com.vacker.example.multiple_db.domain.secondary.SecondaryTable1Repository;

@Service("someService")
public class SomeServiceImpl implements SomeService {
	
	@Autowired
	private PrimaryTable1Repository primaryTable1Repository;
	
	@Autowired
	private SecondaryTable1Repository secondaryTable1Repository;
	
	

	@Override
	public void insertPrimaryDB(PrimaryTable1 primaryTable1Obj) {
		primaryTable1Repository.saveAndFlush(primaryTable1Obj);
	}

	@Override
	public void insertSecondaryDB(SecondaryTable1 secondaryTable1Obj) {
		secondaryTable1Repository.saveAndFlush(secondaryTable1Obj);
	}

}
