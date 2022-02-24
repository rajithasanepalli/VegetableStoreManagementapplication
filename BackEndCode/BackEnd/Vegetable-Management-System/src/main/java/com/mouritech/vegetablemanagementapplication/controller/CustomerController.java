package com.mouritech.vegetablemanagementapplication.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.mouritech.vegetablemanagementapplication.exception.ResourceNotFoundException;
import com.mouritech.vegetablemanagementapplication.model.Customer;
import com.mouritech.vegetablemanagementapplication.repository.CustomerRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController 
@RequestMapping("/api/v1")

public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	//create an customers
	@PostMapping("/customers")
	public Customer saveCustomer(@Valid @RequestBody Customer customer)
	{
		return customerRepository.save(customer);
	}
	
	//get all customers
	@GetMapping("/customers")
	public List<Customer> getAllCustomers()
	{
		return customerRepository.findAll();
	}
	
	//update customers
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Long customerId,
	         @Valid @RequestBody Customer customerDetails) throws ResourceNotFoundException {
	        Customer customer = customerRepository.findById(customerId)
	        .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));

	        customer.setCustomerName(customerDetails.getCustomerName());
	        customer.setCustomerAddress(customerDetails.getCustomerAddress());
	        customer.setCustomerMobileNo(customerDetails.getCustomerMobileNo());
	        customer.setCustomerEmail(customerDetails.getCustomerEmail());
	        
	        final Customer updatedCustomer = customerRepository.save(customer);
	        return ResponseEntity.ok(updatedCustomer);
	    }	
	
	
	//delete Customers
	@DeleteMapping("/customers/{customerId}")
	public ResponseEntity<?> deleteCustomer( 
			@PathVariable(value = "customerId") Long customerId)
	throws ResourceNotFoundException
	{
		return customerRepository.findById(customerId).map(customer -> {
			customerRepository.delete(customer);
			Map<String,Boolean> response =new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		}).orElseThrow(()->new ResourceNotFoundException("Customer not found"));
	}
	
	//get customers by orderId
	@GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getOrderById(@PathVariable(value = "id") Long customerId)
        throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customerId)
          .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));
        
        
        return ResponseEntity.ok().body(customer);
    }
}
