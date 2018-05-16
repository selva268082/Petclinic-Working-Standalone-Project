package org.springframework.samples.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.test.bean.Bus;
import org.springframework.samples.test.repo.BusRepo;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
	BusRepo busRepo;
	
	public List<Bus> testPullService()
	{
		return busRepo.findAll();
	}
	
	
	
	public Bus testSaveService(Bus bus)
	{
		return busRepo.save(bus);
	}
	
}
