package ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.Repository.CustomerRepository;
import ecommerce.entity.Customer;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Customer getCustomerById(Long id) {
		 return customerRepository.findById(id).orElse(null);
	}
	
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
	
	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
	}
}
