package com.capbranding.entities;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "employee_details")
public class Employee {
	

	@Id
	@Column(name = "employee_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="employee_seq")
	@SequenceGenerator(name = "employee_seq",sequenceName = "employee_seq", allocationSize=1)
	private int employeeId;

	@Column(name = "first_name")
	@NotNull(message= "First Name can not be null")
	private String firstName;

	@Column(name = "last_name")
	@NotNull(message = "Last Name should not be null")
	private String lastName;

	@Column(name = "mobile_number")
	@Size(min = 10, message="Mobile no should be in 10 digits")
	private String mobileNumber;

	@Column(name = "email")
	@Email(message = "Email should be valid")
	private String email;

	@Column(name = "address")
	@NotEmpty(message = "address cannot be empty")
	private String address;

	//mapping
	@JsonIgnore
	@OneToOne(mappedBy="employeeAdd")
	private Address addressEmp;

	@JsonIgnore
	@OneToOne(mappedBy="employeeUser")
	private User user;

	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employeeOrder")
	private Set<Order> products = new HashSet<Order>();

	@JsonIgnore
	@OneToOne(mappedBy="employeeCart")
	private Cart cart;



	public Employee() {
		super();
	}

	public Employee(int employeeId, String firstName, String lastName, String mobileNumber, String email,
			String address, Address addressEmp, User user, Set<Order> products, Cart cart) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.address = address;
		this.addressEmp = addressEmp;
		this.user = user;
		this.products = products;
		this.cart = cart;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Address getAddressEmp() {
		return addressEmp;
	}

	public void setAddressEmp(Address addressEmp) {
		this.addressEmp = addressEmp;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Order> getProducts() {
		return products;
	}

	public void setProducts(Set<Order> products) {
		this.products = products;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mobileNumber=" + mobileNumber + ", email=" + email + ", address=" + address + ", addressEmp="
				+ addressEmp + ", user=" + user + ", products=" + products + ", cart=" + cart + "]";
	}


	
}