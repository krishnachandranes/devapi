package com.wncdevapi.devapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wncdevapi.devapi.entity.County;

@Repository
public interface CountyRepository extends CrudRepository<County,Long>{

}
