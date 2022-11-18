package com.onlinegrocerydeliverysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinegrocerydeliverysystem.models.Product;

/**
 * This is interface for ProductRepository which extends the Jpa Repository to
 * get method alredy defined in it
 * 
 *
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

	public boolean existsById(long productId);

}
