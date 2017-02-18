package com.addressbook.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "HOME" database table.
 * 
 */
@Entity
@Table(name="\"HOME\"")
@NamedQuery(name="HOME.findAll", query="SELECT h FROM Home h")
public class Home implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="home_id")
	private Integer homeId;

	private String address;

	private String name;

	private String phone;

	public Home() {
	}

	public Integer getHomeId() {
		return this.homeId;
	}

	public void setHomeId(Integer homeId) {
		this.homeId = homeId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}