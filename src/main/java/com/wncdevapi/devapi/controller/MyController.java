package com.wncdevapi.devapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wncdevapi.devapi.entity.County;
import com.wncdevapi.devapi.service.CountyService;

@Controller
public class MyController {
	@Autowired
	private CountyService countyService;
	
	 @RequestMapping(value = "/counties/{id}", method= RequestMethod.GET,produces = "application/json")
    public ResponseEntity<County> getCity(@PathVariable Long id) {

        County county= countyService.findById(id);
        return new ResponseEntity<>(county,HttpStatus.OK);
    }

	 
//	 @PostMapping(value = "/cities", consumes = MediaType.APPLICATION_JSON_VALUE,
//	            produces = MediaType.APPLICATION_JSON_VALUE)
//	    public County createCity(@RequestBody @Valid City city) {
//
//	        return countyService.save(city);
//	    }

	    @GetMapping(value = "/counties")
	    public ResponseEntity<List<County>> findAll() {

	        List<County> counties = countyService.findAll();
	        return new ResponseEntity<>(counties,HttpStatus.OK);
	    }
}