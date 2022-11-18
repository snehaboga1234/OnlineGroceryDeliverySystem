package com.onlinegrocerydeliverysystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinegrocerydeliverysystem.models.CartItem;

/**
 * Repository interface to persist and retrieve CartItem entities from the
 * database.
 * 
 * @see CartItemRepository
 * @version 1.0
 */
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

	/**
	 * Method to find cart items by user id.
	 * 
	 * @param productId
	 * @return list of cart items associated with a given user id.
	 */
	public List<CartItem> findAllByUserId(long userId);

	/**
	 * 
	 * @param userId
	 * @param productId
	 * @return a list of cart items associated with a user id and a product id. This
	 *         list will always have either 0 or 1 element.
	 */
	public List<CartItem> findAllByUserIdAndProductId(long userId, long productId);

}