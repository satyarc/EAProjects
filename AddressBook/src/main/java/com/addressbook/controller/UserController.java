package com.addressbook.controller;


import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.addressbook.entity.Home;
import com.addressbook.entity.PharmaRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

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
	

	@RequestMapping(value = "/addAddressS", method = RequestMethod.POST )
	public @ResponseBody String addAddress(@RequestBody  Home  home){
		phaRepos.save(home);
		List<Home>addresses  =  (List<Home>)phaRepos.findAll();
		String response = gson.toJson(addresses); 
		return  response;
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
