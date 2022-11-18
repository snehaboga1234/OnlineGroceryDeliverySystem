package com.onlinegrocerydeliverysystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinegrocerydeliverysystem.dto.ProductDto;
import com.onlinegrocerydeliverysystem.exceptions.ProductNotFoundException;
import com.onlinegrocerydeliverysystem.models.Product;
import com.onlinegrocerydeliverysystem.service.ProductService;

/**
 * RestController is used for making restful web services RequestMapping This
 * annotation maps HTTP requests to handler methods of RESTcontrollers
 * 
 * @see ProductController
 * @version 1.0
 */
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	/**
	 * ProductController Parameterized constructor
	 * 
	 * @param productService
	 */
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	/**
	 * This is PostMapping annotated methods handle the HTTP POST requests matched
	 * with given URI expression.
	 * 
	 * @param product
	 * @return HTTP status as created
	 */
	// build create product REST API
	@PostMapping("/add")
	public ResponseEntity<ProductDto> saveProduct(@RequestBody Product product) {
		return new ResponseEntity<>(new ProductDto(productService.saveProduct(product)), HttpStatus.CREATED);
	}

	/**
	 * This The GetMapping annotion handles a GET request
	 * 
	 * @return List<ProductDto>
	 */
	// build get all product REST API
	@GetMapping("/viewAll")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	/**
	 * This PutMMapping Annotation for mapping HTTP PUT requests onto specific
	 * handler methods
	 * 
	 * @param productId
	 * @param product
	 * @return ResponseEntity in HTTP response: status code, headers, and body
	 * @throws ProductNotFoundException
	 */

	// http://localhost:8082/product/update/1
	@PutMapping("/update/{productId}")

	public ResponseEntity<ProductDto> updateProduct(@PathVariable(value = "productId") long productId,
			@RequestBody Product product) throws ProductNotFoundException {
		return new ResponseEntity<>(new ProductDto(productService.updateProduct(product, productId)), HttpStatus.OK);
	}

	/**
	 * This DeleteMapping Annotation maps HTTP DELETE requests onto specific handler
	 * methods.
	 * 
	 * @param productId
	 * @return ResponseEntity in HTTP response: status code, headers, and body
	 * @throws ProductNotFoundException
	 */
	// build delete product REST API
	// http://localhost:8082/product/1
	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable("productId") long productId)
			throws ProductNotFoundException {

		// delete employee from DB
		productService.deleteProduct(productId);

		return new ResponseEntity<>("Product deleted successfully!.", HttpStatus.OK);
	}

	/**
	 * This The GetMapping annotion handles a GET request
	 * 
	 * @param productId
	 * @return ResponseEntity in HTTP response: status code, headers, and body
	 * @throws ProductNotFoundException
	 */
	// build get product by id REST API
	// http://localhost:8082/product/get/1

	@GetMapping("/get/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable("productId") Long productId)
			throws ProductNotFoundException {
		return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.OK);
	}

}
