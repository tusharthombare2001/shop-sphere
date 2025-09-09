package ecommerce.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.Repository.OrderRepository;
import ecommerce.Repository.ProductRepository;
import ecommerce.entity.Customer;
import ecommerce.entity.Order;
import ecommerce.entity.OrderItem;
import ecommerce.entity.Product;

@Service
public class OrderService {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderRepository orderRepository;

	public Order placeOrder(Long customerId, Map<Long, Integer> productQuantities) {
		Order order = new Order();
		order.setOrderDate(new Date());
		order.setStatus("PLACED");

		Customer customer = new Customer();
		customer.setId(customerId);
		order.setCustomer(customer);

		List<OrderItem> orderItems = new ArrayList<>();

		for (Map.Entry<Long, Integer> entry : productQuantities.entrySet()) {
			Long productId = entry.getKey();
			int quantity = entry.getValue();

			Product product = productRepository.findById(productId)
					.orElseThrow(() -> new RuntimeException("Product not found"));

			OrderItem item = new OrderItem();
			item.setProduct(product);
			item.setQuantity(quantity);
			item.setPrice(product.getPrice()); 
			item.setOrder(order);

			orderItems.add(item);
		}

		order.setOrderItems(orderItems);

		return orderRepository.save(order);
	}

	public List<Order> getOrdersByCustomer(Long customerId) {
		return orderRepository.findByCustomerId(customerId);
	}

	public double calculateTotal(Long orderId) {
		Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
		return order.getTotalPrice();
	}

}
