package com.mouritech.vegetablemanagementapplication.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@Column(name = "order_id")
	private String orderId;

	@Column(name = "custId")
	private Long customerId;

	@Column(name = "CustomerName")
	private String customerName;

	@Column(name = "CustomerMobile")
	private String customerMobile;

	@Column(name = "order_date")
	private Date orderDate;

	public Order() {
		super();
	}

	public Order(String orderId, Long customerId, String customerName, String customerMobile, Date orderDate) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerMobile = customerMobile;
		this.orderDate = orderDate;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerId=" + customerId + ", customerName=" + customerName
				+ ", customerMobile=" + customerMobile + ", orderDate=" + orderDate + "]";
	}

}
