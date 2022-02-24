package com.mouritech.vegetablemanagementapplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CustomerId")
	private Long CustomerId;
	@Column(name="CustomerName")
	private String CustomerName;
	@Column(name="CustomerAddress")
	private String CustomerAddress;
	@Column(name="CustomerMobileNo")
	private String CustomerMobileNo;
	@Column(name="CustomerEmail")
	private String CustomerEmail;
	
	
	public Long getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(Long customerId) {
		CustomerId = customerId;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getCustomerAddress() {
		return CustomerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		CustomerAddress = customerAddress;
	}
	public String getCustomerMobileNo() {
		return CustomerMobileNo;
	}
	public void setCustomerMobileNo(String customerMobileNo) {
		CustomerMobileNo = customerMobileNo;
	}
	public String getCustomerEmail() {
		return CustomerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		CustomerEmail = customerEmail;
	}
	@Override
	public String toString() {
		return "Customer [CustomerId=" + CustomerId + ", CustomerName=" + CustomerName + ", CustomerAddress="
				+ CustomerAddress + ", CustomerMobileNo=" + CustomerMobileNo + ", CustomerEmail=" + CustomerEmail + "]";
	}
	public Customer(Long customerId, String customerName, String customerAddress, String customerMobileNo,
			String customerEmail) {
		super();
		CustomerId = customerId;
		CustomerName = customerName;
		CustomerAddress = customerAddress;
		CustomerMobileNo = customerMobileNo;
		CustomerEmail = customerEmail;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
