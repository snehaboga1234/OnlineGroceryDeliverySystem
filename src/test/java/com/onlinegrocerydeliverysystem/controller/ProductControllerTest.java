package com.onlinegrocerydeliverysystem.controller;

/**
 * Test Cases for Controller class 
 * @see ProductControllerTest
 */
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.onlinegrocerydeliverysystem.dto.ProductDto;
import com.onlinegrocerydeliverysystem.exceptions.ProductAlreadyExistException;
import com.onlinegrocerydeliverysystem.exceptions.ProductNotFoundException;
import com.onlinegrocerydeliverysystem.models.Product;
import com.onlinegrocerydeliverysystem.service.ProductService;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

	/**
	 * Creation of mockobject of ProductController
	 */
	@InjectMocks
	ProductController productController;
	/**
	 * Creation of mockobject of ProductService
	 */
	@Mock
	ProductService productService;

	/**
	 * This is Test for create Products
	 * 
	 * @throws ProductNotFoundException
	 * @throws ProductAlreadyExistException
	 */
	@Test
	void testCreateProduct() throws ProductNotFoundException, ProductAlreadyExistException {

		Product prodOne = new Product("Apple", 20, 100, "Fruits");
		prodOne.setProductId(10L);
		Mockito.when(productService.saveProduct(prodOne)).thenReturn(prodOne);
		assertEquals(new ProductDto(prodOne), productController.saveProduct(prodOne).getBody());

	}

	/**
	 * This is Test for update Products
	 * 
	 * @throws ProductNotFoundException
	 */
	@Test
	void testUpdateProduct() throws ProductNotFoundException {
		Product product = new Product("Mango", 20, 200, "Fruits");
		product.setProductId(10L);
		Mockito.when(productService.updateProduct(product, 11L)).thenReturn(product);
		assertEquals(new ProductDto(product), productController.updateProduct(11L, product).getBody());
	}

	/**
	 * This is Test for getAll Products
	 * 
	 */
	@Test
	void testGetallProducts() {

		List<Product> list = new ArrayList<>();
		Product prodOne = new Product("Apple", 20, 100, "Fruits");
		Product prodTwo = new Product("Mango", 30, 100, "Fruits");
		Product prodThree = new Product("Pineapple", 60, 100, "Fruits");
		prodOne.setProductId(1L);
		prodTwo.setProductId(2L);
		prodThree.setProductId(3L);
		list.add(prodOne);
		list.add(prodTwo);
		list.add(prodThree);

		Mockito.when(productService.getAllProducts()).thenReturn(list);

		List<Product> productList = productController.getAllProducts();
		assertEquals(3, productList.size());

	}

	/**
	 * This is Test for delete Products
	 * 
	 * @throws ProductNotFoundException
	 */
	@Test
	void testDeleteProduct() throws ProductNotFoundException {
		Product prodOne = new Product("Apple", 20, 100, "Fruits");

		productController.deleteProduct(10);
		assertEquals("Product deleted successfully!.", productController.deleteProduct(10L).getBody());
	}

}
