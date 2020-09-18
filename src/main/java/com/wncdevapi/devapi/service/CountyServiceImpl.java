package com.wncdevapi.devapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wncdevapi.devapi.entity.County;
import com.wncdevapi.devapi.exception.CountyNotFoundException;
import com.wncdevapi.devapi.exception.NoDataFoundException;
import com.wncdevapi.devapi.repository.CountyRepository;

@Service
public class CountyServiceImpl implements CountyService{

	@Autowired
	CountyRepository countyRepo;
	
	@Override
	public County findById(Long id) {
		return countyRepo.findById(id).orElseThrow(()->new CountyNotFoundException(id));
	}

	@Override
	public County save(County county) {
		return countyRepo.save(county);
	}

	@Override
	public List<County> findAll() {
		List<County> counties = (List<County>) countyRepo.findAll();

	        if (counties==null ||counties.isEmpty()) {

	            throw new NoDataFoundException();
	        }

	        return counties;
	}

}