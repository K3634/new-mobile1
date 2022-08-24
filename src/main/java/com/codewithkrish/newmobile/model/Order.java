package com.codewithkrish.newmobile.model;

import com.codewithkrish.newmobile.model.Product;

public class Order extends Product {
	   private int orderId;
	   
	   private int quantity;
	   private String date;

	   public Order() {
		
	   }

	public Order(int orderId, int quantity, String date) {
		super();
		this.orderId = orderId;
		this.quantity = quantity;
		this.date = date;
	}

	public Order( int quantity, String date) {
		super();
		this.quantity = quantity;
		this.date = date;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	  @Override
	  public String toString() {
		  return "Order [orderId=" + orderId + ",quantity="+quantity+",date="+date+"]";
	  }
	   
	}
