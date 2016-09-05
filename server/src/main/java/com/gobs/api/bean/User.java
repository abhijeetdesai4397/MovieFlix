package com.gobs.api.bean;

import java.util.Arrays;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
/*@NamedQueries({
				@NamedQuery(name="Users.getAllUsers",query="Select u from Users u"),
				@NamedQuery(name="Users.getUserByEmail", query="select u from Users u where u.email=:email")
			 })*/
@NamedNativeQuery(name="Users.finaAll",query="select * from users",resultClass=User.class)
public class User {

	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_user_id")
	private String id;
	@Column(nullable=false)
	private String firstName;
	@Column(nullable=false)
	private String lastName;
	@JoinColumn(nullable=false)
	@ManyToOne
	private Address address;
	@Column(nullable=false,unique=true)
	private String email;
	@Column(nullable=false)
	private String phoneNo;
	@Column(nullable=false)
	private boolean isAdmin;
	@Column(nullable=false)
	private char[] password;
	
	public User()
	{
		this.id=UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", email=" + email + ", phoneNo=" + phoneNo + ", isAdmin=" + isAdmin + ", password="
				+ Arrays.toString(password) + "]";
	}

	
	
}
