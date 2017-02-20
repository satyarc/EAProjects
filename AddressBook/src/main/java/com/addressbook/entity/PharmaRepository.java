package com.addressbook.entity;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PharmaRepository extends CrudRepository<Home, Integer> {

	List<Home> findByHomeId(Integer homeId);
	Home save(Home home);
	
	}


