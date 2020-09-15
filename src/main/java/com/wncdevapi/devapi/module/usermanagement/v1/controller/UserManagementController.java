package com.wncdevapi.devapi.module.usermanagement.v1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wncdevapi.devapi.module.usermanagement.v1.dto.UserV1;
import com.wncdevapi.devapi.module.usermanagement.v1.dto.UserV2;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/usermanagement")
@Api(value="usermanagement", description="Operations pertaining to usermanagement")
public class UserManagementController {
	
	// @ApiOperation(value = "helo",response =ResponseEntity.class)
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Successfully retrieved list"),
	            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	    })
	
	
		/*
		 * @RequestMapping(value = "v1/hello", method= RequestMethod.GET,produces =
		 * "application/json") ResponseEntity<String>hello(){ return new
		 * ResponseEntity<>("Hello new",HttpStatus.OK);
		 * 
		 * }
		 */
	 
	 @ApiOperation(value = "Print the User information")
	 @RequestMapping(value = "v1/user", method= RequestMethod.GET,produces = "application/json")
	  public ResponseEntity<UserV1> user() {
		UserV1 usr=new UserV1();
		usr.setName("Bob Charlie");
	    return new  ResponseEntity<>(usr,HttpStatus.OK);
	  }
	
		 @ApiOperation(value = "Print the User information")
		 @RequestMapping(value = "v2/user", method= RequestMethod.GET,produces = "application/json")
	  public ResponseEntity<UserV2> user2() {
		UserV2 usr=new UserV2();
		usr.setFirstName("Bob");
		usr.setLastName("Charlie");
	    return new  ResponseEntity<>(usr,HttpStatus.OK);
	  }
	
	 @ApiOperation(value = "Print the age information based on Year of Birth")
	 @RequestMapping(value = "v1/age", method= RequestMethod.GET,produces = "application/json")
	ResponseEntity<String> age(
	  @RequestParam("yearOfBirth") int yearOfBirth) {
	 
	    if (isInFuture(yearOfBirth)) {
	        return new ResponseEntity<>(
	          "Year of birth cannot be in the future", 
	          HttpStatus.BAD_REQUEST);
	    }
	 
	    return new ResponseEntity<>(
	      "Your age is " + calculateAge(yearOfBirth), 
	      HttpStatus.OK);
	}

	private String calculateAge(int yearOfBirth) {
		int age=2020-yearOfBirth;
		return String.valueOf(age);
	}

	private boolean isInFuture(int yearOfBirth) {
		if (yearOfBirth>2020)
			return true;
		else
			return false;
	}


}
