package com.onlinegrocerydeliverysystem.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.onlinegrocerydeliverysystem.exceptions.ProductAlreadyExistException;
import com.onlinegrocerydeliverysystem.exceptions.ProductNotFoundException;
import com.onlinegrocerydeliverysystem.models.Product;
import com.onlinegrocerydeliverysystem.repository.ProductRepository;
import com.onlinegrocerydeliverysystem.service.ProductService;

/**
 * This is the ProductServiceImpl test Class to test the methods in it
 * 
 * @see ProductServiceImplTest
 *
 */
@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

	/**
	 * Creation of MockObject of Product Entity
	 */
	@InjectMocks
	Product product;

	/**
	 * Creation of MockObject of ProductService
	 */
	@Mock
	ProductService productService;

	/**
	 * Creation of MockObject of ProductRepository
	 */
	@Mock
	ProductRepository productRepository;

	/**
	 * Test for get allproducts
	 */
	@Test
	void getAllProductsTest() {
		List<Product> list = new ArrayList<>();
		Product prodOne = new Product("Apple", 20, 100, "Fruits");
		Product prodTwo = new Product("Mango", 30, 100, "Fruits");
		Product prodThree = new Product("Pineapple", 60, 100, "Fruits");

		list.add(prodOne);
		list.add(prodTwo);
		list.add(prodThree);

		Mockito.when(productService.getAllProducts()).thenReturn(list);

		List<Product> productList = productService.getAllProducts();

		assertEquals(3, productList.size());

		verify(productService, times(1)).getAllProducts();
	}

	/**
	 * Test to get the products by its id
	 * 
	 * @throws ProductNotFoundException
	 */
	@Test
	void getProductByIdTest() throws ProductNotFoundException {

		Mockito.when(productService.getProductById(1L)).thenReturn(new Product("Apple", 20, 100, "Fruits"));
		Product p = productService.getProductById(1L);
		p.setProductId(9L);
		assertEquals("Apple", p.getProductName());
		assertEquals(9L, p.getProductId());
	}

	/**
	 * Test for create products
	 * 
	 * @throws ProductAlreadyExistException
	 */
	@Test
	void createProductTest() throws ProductAlreadyExistException {
		Product p = new Product("Apple", 20, 100, "Fruits");
		p.setProductId(1L);
		productService.saveProduct(p);
		assertEquals("Apple", p.getProductName());
		verify(productService, times(1)).saveProduct(p);
	}

	/**
	 * Test for delete products
	 * 
	 * @throws ProductNotFoundException
	 */
	@Test
	void deleteProduct() throws ProductNotFoundException {

		Product p = new Product("Apple", 20, 100, "Fruits");
		p.setProductId(9L);
		productService.deleteProduct(9L);
		verify(productService, times(1)).deleteProduct(9L);
	}

	/**
	 * Test for updateProducts
	 * 
	 * @throws ProductNotFoundException
	 */
	@Test
	void updateProduct() throws ProductNotFoundException {

		Product p = new Product("Apple", 20, 500, "Fruits");
		productService.updateProduct(p, 3L);
		verify(productService, times(1)).updateProduct(p, 3L);
	}

}
