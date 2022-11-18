package com.onlinegrocerydeliverysystem.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



/**
* Entity class to represent an order item.
*
* @see OrderItem
* @version 1.0
*/
@Entity
@Table(name = "orderitems")
public class OrderItem {



/**
* Order Item Id. Primary Key of OrderItem entity.
*/
@Id
@GeneratedValue
@Column(name = "id")
private long orderItemId;



/**
* Product Id associated with the order item.
*/
@Column(name = "productid")
private long productId;



/**
* Product quantity.
*/
@Column(name = "quantity")
private int quantity;



/**
* Product price.
*/
@Column(name = "price")
private double price;



/**
* Order Id associated with the order item.
*/
@Column(name = "order_id")
private long orderId;



/**
* Order associated with the order item.
*/
@ManyToOne
@JoinColumn(name = "order_id", referencedColumnName = "id", insertable = false, updatable = false)
private Order order;



/**
* Product associated with the order item.
*/
@ManyToOne
@JoinColumn(name = "productid", referencedColumnName = "p_id", insertable = false, updatable = false)
Product product;



/**
* Default constructor of the OrderItem class.
*/
public OrderItem() {
super();
}



/**
* Parameterized constructor of the order item class.
*
* @param productId
* @param orderId
* @param quantity
* @param price
*/
public OrderItem(long productId, long orderId, int quantity, double price) {
super();
this.productId = productId;
this.orderId = orderId;
this.quantity = quantity;
this.price = price;
}



public long getOrderItemId() {
return orderItemId;
}



public void setOrderItemId(long orderItemId) {
this.orderItemId = orderItemId;
}



public long getProductId() {
return productId;
}



public void setProductId(long productId) {
this.productId = productId;
}



public int getQuantity() {
return quantity;
}



public void setQuantity(int quantity) {
this.quantity = quantity;
}



public double getPrice() {
return price;
}



public void setPrice(double price) {
this.price = price;
}



public long getOrderId() {
return orderId;
}



public void setOrderId(long orderId) {
this.orderId = orderId;
}


public void setOrder(Order order) {
this.order = order;
}



public Product getProduct() {
return product;
}



public void setProduct(Product product) {
this.product = product;
}



}