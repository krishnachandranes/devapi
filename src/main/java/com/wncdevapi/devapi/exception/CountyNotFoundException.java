package com.wncdevapi.devapi.exception;


public class CountyNotFoundException extends RuntimeException{

	public CountyNotFoundException(Long id)
	{
		super(String.format("County with Id %d Not Found:",id));
	}
}
