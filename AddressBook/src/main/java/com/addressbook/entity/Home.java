package com.addressbook.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the "HOME" database table.
 * 
 */
@XmlRootElement
@Entity
@Table(name="\"HOME\"")
@NamedQuery(name="HOME.findAll", query="SELECT h FROM Home h")
public class Home implements Serializable {
	@JsonIgnore
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="home_id")
	private Integer homeId;

	@XmlElement
	private String address;

	@XmlElement
	private String name;

	@XmlElement
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