package ecommerce.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.entity.Order;
import ecommerce.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	  @Autowired
	    private OrderService orderService;
	  
	 
	  
	    @PostMapping("/place/{customerId}")
	    public Order placeOrder(@PathVariable Long customerId,
	                            @RequestBody Map<Long, Integer> productQuantities) {
	        return orderService.placeOrder(customerId, productQuantities);
	    }
	    
	    
	   
	    @GetMapping("/history/{customerId}")
	    public List<Order> getOrderHistory(@PathVariable Long customerId) {
	        return orderService.getOrdersByCustomer(customerId);
	    }
	    
	    
	    
	    @GetMapping("/{orderId}/total")
	    public double getOrderTotal(@PathVariable Long orderId) {
	        return orderService.calculateTotal(orderId);
	    }

}
