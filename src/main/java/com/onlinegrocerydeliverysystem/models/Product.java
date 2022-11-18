package com.onlinegrocerydeliverysystem.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ** This is an Entity class here Product is an Entity class
 * 
 * @see Products
 * 
 *
 */
@Entity
@Table(name = "Stocks")
public class Product {

	/**
	 * Id annotation is to show primary key for Product table
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "p_id")
	private Long productId;

	@Column(name = "p_name")
	private String productName;

	@Column(name = "p_price")
	private Integer productPrice;

	@Column(name = "p_quantity")
	private Integer productQuantity;

	@Column(name = "p_category")
	private String productCategory;

	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productPrice
	 */
	public Integer getProductPrice() {
		return productPrice;
	}

	/**
	 * @param productPrice the productPrice to set
	 */
	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * @return the productQuantity
	 */
	public Integer getProductQuantity() {
		return productQuantity;
	}

	/**
	 * @param productQuantity the productQuantity to set
	 */
	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	/**
	 * @return the productCategory
	 */
	public String getProductCategory() {
		return productCategory;
	}

	/**
	 * @param productCategory the productCategory to set
	 */
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public Product() {
		super();
	}

	/**
	 * 
	 * @param productName
	 * @param productPrice
	 * @param productQuantity
	 * @param productCategory
	 */
	public Product(String productName, Integer productPrice, Integer productQuantity, String productCategory) {

		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.productCategory = productCategory;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productQuantity=" + productQuantity + ", productCategory=" + productCategory + "]";
	}

}
