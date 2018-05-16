package org.springframework.samples.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.test.bean.Bus;
import org.springframework.samples.test.bean.Passenger;
import org.springframework.samples.test.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 

@RestController
@RequestMapping(value="/pulldata")
public class TestController {
	@Autowired
	TestService testPullService;
	
	@RequestMapping(value="/data", method=RequestMethod.GET)
	public ResponseEntity<List<Bus>> fetchDetails()
	{
		System.out.println("------------------><---------------");
		Bus bus=new Bus();
		//bus.setBusID(1);
		bus.setName("PNB");
		
		Passenger pax=new Passenger();
		//pax.setPaxId(1);
		pax.setPaxname("selva");
		
		List paxList=new ArrayList();
		paxList.add(pax);
		bus.setPaxLst(paxList);
		
		pax.setBus(bus);
		
		testPullService.testSaveService(bus);
		
		List<Bus> lstData= testPullService.testPullService();
		if(!lstData.isEmpty()){
			lstData.stream().forEach(dat-> System.out.println(dat.getBusID()+ " "+dat.getName() +" "+ dat.getPaxLst()));
		}
		
		return new ResponseEntity<List<Bus>>(lstData,HttpStatus.OK);
		
	}

}
