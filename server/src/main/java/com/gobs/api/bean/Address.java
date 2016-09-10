package com.gobs.api.bean;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name="Address.checkAddressExist",query="Select a from Address a "
			+ "where lower(a.address1)=lower(:address1) "
			+ "AND lower(a.address2)=lower(:address2) "
			+ "AND lower(a.city)=lower(:city) "
			+ "AND lower(a.state)=lower(:state) "
			+ "AND lower(a.country)=lower(:country)")
})
public class Address {

	@Id
	private String id;
	@Column(nullable=false)
	private String address1;
	private String address2;
	@Column(nullable=false)
	private String city;
	@Column(nullable=false)
	private String state;
	@Column(nullable=false)
	private String country;
	
	public Address()
	{
		this.id=UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id.trim();
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1.trim();
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2.trim();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city.trim();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state.trim();
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country.trim();
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", state="
				+ state + ", country=" + country + "]";
	}
	
}
