package com.onlinegrocerydeliverysystem.dto;

import java.util.Objects;

import com.onlinegrocerydeliverysystem.models.Product;

/**
 * DTO (Data Transfer Object) class for the Product class. Used to hide the
 * product stock quantity from the client.
 * 
 * @see ProductDto
 * @version 1.0
 */
public class ProductDto {

	@Override
	public int hashCode() {
		return Objects.hash(productCategory, productName, productPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDto other = (ProductDto) obj;
		return Objects.equals(productCategory, other.productCategory) && Objects.equals(productName, other.productName)
				&& productPrice == other.productPrice;
	}

	private long productId;

	/**
	 * Name of the product.
	 */
	private String productName;

	/**
	 * Price of the product.
	 */
	private int productPrice;

	/**
	 * Category of the product. For instance syrup, tablet etc.
	 */
	private String productCategory;

	private int productQuantity;

	/**
	 * Default constructor of the class.
	 */
	public ProductDto() {
		super();
	}

	/**
	 * Parameterized constructor that initializes the attributes of product dto with
	 * required attributes of the product object.
	 * 
	 * @param product
	 */
	public ProductDto(Product product) {
		this.productId = product.getProductId();
		this.productName = product.getProductName();
		this.productPrice = product.getProductPrice();
		this.productCategory = product.getProductCategory();
		this.productQuantity = product.getProductQuantity();
	}

	/**
	 * @return the productId
	 */
	public long getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(long productId) {
		this.productId = productId;
	}

	/**
	 * Getter method for product name.
	 * 
	 * @return name of the product.
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Setter method for product name.
	 * 
	 * @param productName
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Getter method for product price.
	 * 
	 * @return price of the product.
	 */
	public int getProductPrice() {
		return productPrice;
	}

	/**
	 * Setter method for product price.
	 * 
	 * @param productPrice
	 */
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * Getter method for product category.
	 * 
	 * @return category of the product.
	 */
	public String getProductCategory() {
		return productCategory;
	}

	/**
	 * Setter method for product category.
	 * 
	 * @param productCategory
	 */
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	/**
	 * @return the productQuantity
	 */
	public int getProductQuantity() {
		return productQuantity;
	}

}
