package com.addressbook.controller;


import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//import com.nmbr.mna.pharma.entity.UserDetail;


import com.addressbook.entity.Home;
import com.addressbook.entity.PharmaRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class UserController {

	@Autowired
	PharmaRepository phaRepos;
	
	Gson gson = new GsonBuilder().create();
	
	@RequestMapping("/addresses")
	public @ResponseBody String getAddresses(){
		List<Home> addresses =  (List<Home>)phaRepos.findAll();
		return gson.toJson(addresses);
	}
	
	@RequestMapping("/addAddress")
	public @ResponseBody String addAddress(String input){
		List<Home> addresses =  (List<Home>)phaRepos.findAll();
		Addressfields fields =  gson.fromJson(input, Addressfields.class);
		//phaRepos.save(fields.name);
		return "Added" + fields.name + fields.address + fields.phone;
	}
	
	@RequestMapping("/deleteAddress")
	public @ResponseBody String deleteAddress(){
		List<Home> addresses =  (List<Home>)phaRepos.findAll();
		return gson.toJson(addresses);
	}
	
	@RequestMapping("/name")
	public @ResponseBody String getUsername(int id){
		List<Home> user =  phaRepos.findByHomeId(new Integer(id));
		return user.get(0).getName();
	}
	
	@RequestMapping("/id")
	public @ResponseBody  String getUserId(int id){
		List<Home> user =  phaRepos.findByHomeId(new Integer(id));
		return user.get(0).getName();
	}
}
