package com.mouritech.vegetablemanagementapplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vegetable")
public class Vegetable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "veg_id")
	private Long vegId;

	@Column(name = "seller_Id")
	private Long sellerId;
	
	@Column(name = "veg_name")
	private String vegName;

	@Column(name = "price")
	private double price;
	
	@Column(name = "quantity")
	private int quantity;

	public Vegetable() {
		super();
	}
	
	public Vegetable(Long vegId, Long sellerId, String vegName, double price, int quantity) {
		super();
		this.vegId = vegId;
		this.sellerId = sellerId;
		this.vegName = vegName;
		this.price = price;
		this.quantity = quantity;
	}

	public Long getvegId() {
		return vegId;
	}

	public void setvegId(Long vegId) {
		this.vegId = vegId;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getVegName() {
		return vegName;
	}

	public void setVegName(String vegName) {
		this.vegName = vegName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Vegetable [vegId=" + vegId + ", sellerId=" + sellerId + ", vegName=" + vegName + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}

}
