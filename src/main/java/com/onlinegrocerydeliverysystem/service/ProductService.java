package com.onlinegrocerydeliverysystem.service;

import java.util.List;

import com.onlinegrocerydeliverysystem.exceptions.ProductNotFoundException;
import com.onlinegrocerydeliverysystem.models.Product;

/**
 * This is an ProductService interface with method declaration
 * 
 * 
 *
 */
public interface ProductService {

	/**
	 * This method is to save the Product into db
	 * 
	 * @param Product
	 * @return Product
	 * 
	 */
	Product saveProduct(Product product);

	/**
	 * This method gets all the products present into db
	 * 
	 * @return List<Products>
	 */
	List<Product> getAllProducts();

	/**
	 * This is the method to update products into db
	 * 
	 * @param product
	 * @param productId
	 * @return updated products
	 * @throws ProductNotFoundException
	 */
	Product updateProduct(Product product, Long productId) throws ProductNotFoundException;

	/**
	 * This method is for delete the product into db
	 * 
	 * @param productId
	 * @throws ProductNotFoundException
	 */
	void deleteProduct(Long productId) throws ProductNotFoundException;

	/**
	 * This method is for getProduct by id form db
	 * 
	 * @param Id
	 * @throws ProductNotFoundException
	 */

	/**
	 * This method is for get product by its Id
	 * 
	 * @param Id
	 * @return Product
	 * @throws ProductNotFoundException
	 * 
	 */
	Product getProductById(Long productId) throws ProductNotFoundException;

}
