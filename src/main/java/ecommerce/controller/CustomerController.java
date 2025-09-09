package ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.entity.Customer;
import ecommerce.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/saveCustomer")
	public Customer adCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	
	  @GetMapping("/all")
	    public List<Customer> getAllCustomers() {
	        return customerService.getAllCustomers();
	    }
	
	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable Long id) {
		return customerService.getCustomerById(id);
	}
	  @DeleteMapping("/{id}")
	    public String deleteCustomer(@PathVariable Long id) {
	        customerService.deleteCustomer(id);
	        return "Customer deleted successfully!";
	    }
	
}
