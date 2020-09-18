package com.wncdevapi.devapi.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wncdevapi.devapi.entity.County;

public interface CountyService {

	County findById(Long id);
	County save(County county);
	List<County> findAll();
}

