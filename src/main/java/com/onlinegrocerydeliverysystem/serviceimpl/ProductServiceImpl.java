package com.onlinegrocerydeliverysystem.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinegrocerydeliverysystem.exceptions.ProductNotFoundException;
import com.onlinegrocerydeliverysystem.models.Product;
import com.onlinegrocerydeliverysystem.repository.ProductRepository;
import com.onlinegrocerydeliverysystem.service.ProductService;

/**
 * This is ProductServiceImpl class which implements the unimplemented methods
 * by the ProductService
 * 
 * 
 * @see ProductServiceImpl
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	/**
	 * ProductServiceImpl Constructor
	 * 
	 * @param productRepository
	 */

	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	/**
	 * This method is to save the Product in DB
	 * 
	 * @param Product
	 * @return saved Product
	 * 
	 */
	public Product saveProduct(Product product) {

		productRepository.save(product);
		System.out.println("Product added successfully with With ProductId :" + product.getProductId());
		return productRepository.save(product);

	}

	/**
	 * This method is to get the Product from DB
	 * 
	 * @return List<Product>
	 * 
	 */
	@Override
	public List<Product> getAllProducts() {
		System.out.println("List of All Products");
		return productRepository.findAll();
	}

	/**
	 * @param product
	 * @param productId
	 * @throws ProductNotFoundException
	 * @return updated product
	 * 
	 */
	@Override
	public Product updateProduct(Product product, Long productId) throws ProductNotFoundException {

		// we need to check whether product with given id is exist in DB or not
		System.out.println("Product Not Found With productId:" + productId);
		Product existingProduct = productRepository.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException("Product Not Found "));

		if (product.getProductName() != null)
			existingProduct.setProductName(product.getProductName());
		if (product.getProductPrice() != 0)
			existingProduct.setProductPrice(product.getProductPrice());

		if (product.getProductCategory() != null)
			existingProduct.setProductCategory(product.getProductCategory());
		if (product.getProductQuantity() != 0)
			existingProduct.setProductQuantity(product.getProductQuantity());

		System.out.println("Product Updated  successfully with ProductId : " + product.getProductId());
		// save existing product to DB
		productRepository.save(existingProduct);
		return existingProduct;
	}

	/**
	 * @param productId
	 * @throws ProductNotFoundException
	 */
	@Override
	public void deleteProduct(Long productId) throws ProductNotFoundException {

		System.out.println("Product Not Found With productId:" + productId);
		productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product Not Found"));

		System.out.println("Product deleted successfully with Id:" + productId);
		productRepository.deleteById(productId);
	}

	/**
	 * This method is for get product by its Id
	 * 
	 * @param Id
	 * @return Product
	 * @throws ProductNotFoundException
	 * 
	 */

	@Override
	public Product getProductById(Long productId) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		Optional<Product> product = productRepository.findById(productId);
		if (product.isPresent()) {
			return product.get();
		} else {
			System.out.println("Product Not Found");
			throw new ProductNotFoundException("Product Not Found");
		}

	}

}
