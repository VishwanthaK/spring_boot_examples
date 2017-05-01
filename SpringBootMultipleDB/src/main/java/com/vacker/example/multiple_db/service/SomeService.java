package com.vacker.example.multiple_db.service;

import com.vacker.example.multiple_db.domain.primary.PrimaryTable1;
import com.vacker.example.multiple_db.domain.secondary.SecondaryTable1;

public interface SomeService {
	
	void insertPrimaryDB(PrimaryTable1 primaryTable1Obj);
	
	void insertSecondaryDB(SecondaryTable1 secondaryTable1Obj);

}
