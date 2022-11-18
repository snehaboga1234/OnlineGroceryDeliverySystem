package com.onlinegrocerydeliverysystem.serviceimpl;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinegrocerydeliverysystem.exceptions.CartEmptyException;
import com.onlinegrocerydeliverysystem.exceptions.CartItemNotFoundException;
import com.onlinegrocerydeliverysystem.exceptions.NotEnoughStockException;
import com.onlinegrocerydeliverysystem.exceptions.ProductNotFoundException;
import com.onlinegrocerydeliverysystem.exceptions.UserNotFoundException;
import com.onlinegrocerydeliverysystem.models.CartItem;
import com.onlinegrocerydeliverysystem.models.Order;
import com.onlinegrocerydeliverysystem.models.OrderItem;
import com.onlinegrocerydeliverysystem.models.Product;
import com.onlinegrocerydeliverysystem.repository.CartItemRepository;
import com.onlinegrocerydeliverysystem.repository.OrderItemRepository;
import com.onlinegrocerydeliverysystem.repository.OrderRepository;
import com.onlinegrocerydeliverysystem.repository.ProductRepository;
import com.onlinegrocerydeliverysystem.repository.UserRepository;
import com.onlinegrocerydeliverysystem.service.CartItemService;

/**
 * A service class to perform all the CRUD operations on CartItem entity.
 * 
 * @see CartItemServiceImpl
 * @version 1.0
 */
@Service
public class CartItemServiceImpl implements CartItemService {

	/**
	 * Cart item repository object.
	 */
	@Autowired
	private CartItemRepository cartItemRepository;

	/**
	 * User repository object.
	 */
	@Autowired
	UserRepository userRepository;

	/**
	 * Order repository object.
	 */
	@Autowired
	OrderRepository orderRepository;

	/**
	 * Product Repository object.
	 */
	@Autowired
	ProductRepository productRepository;

	/**
	 * Order item repository object.
	 */
	@Autowired
	OrderItemRepository orderItemRepository;

	/**
	 * Service method to add a cart item to a user's cart.
	 * 
	 * @param cartItem
	 * @throws UserNotFoundException
	 * @throws ProductNotFoundException
	 * @throws NotEnoughStockException
	 */
	@Override
	public String addToCart(CartItem cartItem)
			throws UserNotFoundException, ProductNotFoundException, NotEnoughStockException {
		String productQuantityNotAvailableMessage = "The provided product quantity is not available.";
		if (!userRepository.existsById(cartItem.getUserId())) {
			System.out.println("User associated with this cart item does not exist.");
			throw new UserNotFoundException("User associated with this cart item does not exist.");
		}
		if (!productRepository.existsById(cartItem.getProductId())) {
			System.out.println(productRepository.findById(cartItem.getProductId()));
			System.out.println("Product does not exist."+cartItem.getProductId());
			throw new ProductNotFoundException("Product associated with this cart item does not exist.");
		}
		List<CartItem> cartItems = cartItemRepository.findAllByUserIdAndProductId(cartItem.getUserId(),
				cartItem.getProductId());
		Optional<Product> optionalProduct = productRepository.findById(cartItem.getProductId());
		if (!optionalProduct.isPresent()) {
			System.out.println("Could not fetch the product from the database.");
			throw new ProductNotFoundException("Could not fetch the product from the database.");
		}
		if (cartItems.isEmpty() && optionalProduct.get().getProductQuantity() < cartItem.getQuantity()) {
			System.out.println(productQuantityNotAvailableMessage);
			throw new NotEnoughStockException(productQuantityNotAvailableMessage);
		} else if (cartItems.isEmpty()) {
			cartItemRepository.save(cartItem);
			return cartItem.toString() + " successfully added to user's cart.";
		} else if (cartItems.get(0).getQuantity() + cartItem.getQuantity() > optionalProduct.get()
				.getProductQuantity()) {
			System.out.println("Product quantity not enough.");
			throw new NotEnoughStockException(productQuantityNotAvailableMessage);
		} else {
			CartItem existingCartItem = cartItems.get(0);
			existingCartItem.setQuantity(existingCartItem.getQuantity() + cartItem.getQuantity());
			cartItemRepository.save(existingCartItem);
			return existingCartItem.toString() + " successfully added to user's cart.";
		}
	}

	/**
	 * Service method to retrieve a list of cart items in the cart of a user.
	 * 
	 * @param userId
	 * @return list of cart items associated with userId.
	 */
	@Override
	public List<CartItem> getCart(long userId) {

		return cartItemRepository.findAllByUserId(userId);
	}

	/**
	 * Service method to update a cart item.
	 * 
	 * @param cartItemId
	 * @param newCartItem
	 * @throws CartItemNotFoundException
	 * @throws NotEnoughStockException
	 * @throws ProductNotFoundException
	 */
	@Override
	public String updateCartItem(long cartItemId, CartItem newCartItem)
			throws CartItemNotFoundException, NotEnoughStockException, ProductNotFoundException {

		Optional<CartItem> optionalCartItem = cartItemRepository.findById(cartItemId);
		if (!optionalCartItem.isPresent()) {
			System.out.println("Cart item does not exist.");
			throw new CartItemNotFoundException("Cart item with the given id does not exist.");
		}
		Optional<Product> optionalProduct = productRepository.findById(optionalCartItem.get().getProductId());
		if (!optionalProduct.isPresent()) {
			System.out.println("Product in this cart item does not exist.");
			throw new ProductNotFoundException("Product in this cart item does not exist.");
		}
		if (optionalProduct.get().getProductQuantity() < newCartItem.getQuantity()) {
			System.out.println("The provided product quantity is not available");
			throw new NotEnoughStockException("The provided product quantity is not available.");
		} else {
			CartItem existingCartItem = optionalCartItem.get();
			newCartItem.setId(existingCartItem.getId());
			cartItemRepository.save(newCartItem);
			System.out.println("Cart Item successfully updated with CartItemId : " + cartItemId);
			return "Cart Item successfully updated to " + newCartItem.toString();
		}
	}

	/**
	 * Service method to delete a cart item.
	 * 
	 * @param cartItemId
	 * @throws CartItemNotFoundException
	 */
	@Override
	public String deleteCartItem(long cartItemId) throws CartItemNotFoundException {
		Optional<CartItem> optionalCartItem = cartItemRepository.findById(cartItemId);
		if (optionalCartItem.isPresent()) {
			String returnMessage = optionalCartItem.get().toString() + " successfully deleted from user's cart.";
			cartItemRepository.deleteById(cartItemId);

			return returnMessage;
		} else {
			System.out.println("Cart item doesn't exist.");
			throw new CartItemNotFoundException("Cart item with the given id does not exist.");
		}
	}

	@Override
	public String orderCartItem(long userId) throws CartEmptyException, NotEnoughStockException, UserNotFoundException {
		if(!userRepository.existsById(userId))
		{
			System.out.println("No user found with id "+userId);
			throw new UserNotFoundException("No user found with id "+userId);
		}
		List<CartItem> cartItems = cartItemRepository.findAllByUserId(userId);
		if (cartItems.isEmpty())
			throw new CartEmptyException("Cart is empty, please add some items.");
		else {
			Order order = orderRepository.save(new Order(userId, new Date(System.currentTimeMillis())));
			OrderItem item;
			double amount = 0.0;
			for (CartItem items : cartItems) {
				if (items.getQuantity() > items.getProduct().getProductQuantity()) {
					System.out.println("Not enough quantity in stock is present");
					throw new NotEnoughStockException("Sorry, not enough quantity in stock");
				}
			}
			for (CartItem items : cartItems) {
				item = new OrderItem(items.getProductId(), order.getId(), items.getQuantity(),
						items.getProduct().getProductPrice());
				items.getProduct().setProductQuantity(items.getProduct().getProductQuantity() - items.getQuantity());
				productRepository.save(items.getProduct());
				amount += (items.getQuantity() * items.getProduct().getProductPrice());
				orderItemRepository.save(item);
				cartItemRepository.deleteById(items.getId());
			}
			order.setTotalPrice(amount);
			orderRepository.save(order);

			System.out.println("Order placed with order id:  " + order.getId());
			return (""+order.getId());
		}
	}

}
