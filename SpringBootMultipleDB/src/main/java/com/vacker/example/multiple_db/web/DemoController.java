package com.vacker.example.multiple_db.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vacker.example.multiple_db.domain.primary.PrimaryTable1;
import com.vacker.example.multiple_db.domain.secondary.SecondaryTable1;
import com.vacker.example.multiple_db.service.SomeService;

@RestController
@RequestMapping("/test")
public class DemoController {
	
	@Autowired
	private SomeService someService;
	
	@RequestMapping(value = "/insert/primary/db", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insertPrimaryDB(@RequestBody PrimaryTable1 primaryTable1Obj) {
		someService.insertPrimaryDB(primaryTable1Obj);
		return new ResponseEntity<String>("Successfully saved in primary db.", HttpStatus.EXPECTATION_FAILED);
	}
	
	@RequestMapping(value = "/insert/secondary/db", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insertSecondaryDB(@RequestBody SecondaryTable1 secondaryTable1Obj){
		someService.insertSecondaryDB(secondaryTable1Obj);
		return new ResponseEntity<String>("Successfully saved in secondary db.", HttpStatus.EXPECTATION_FAILED);
	}

}
