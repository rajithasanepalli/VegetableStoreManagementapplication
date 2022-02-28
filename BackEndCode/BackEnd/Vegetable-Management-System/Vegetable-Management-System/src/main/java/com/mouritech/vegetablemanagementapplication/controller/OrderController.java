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
import com.mouritech.vegetablemanagementapplication.model.Order;
import com.mouritech.vegetablemanagementapplication.repository.OrderRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController 
@RequestMapping("/api/v1")
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	//create an order
	@PostMapping("/orders")
	public Order saveOrder(@Valid @RequestBody Order order)
	{
		return orderRepository.save(order);
	}
	
	//get all orders
	@GetMapping("/orders")
	public List<Order> getAllOrders()
	{
		return orderRepository.findAll();
	}
	
	//update orders
	@PutMapping("/orders/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable(value = "id") String orderId,
	         @Valid @RequestBody Order orderDetails) throws ResourceNotFoundException {
	        Order order = orderRepository.findById(orderId)
	        .orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + orderId));

	        order.setCustomerName(orderDetails.getCustomerName());
	        order.setCustomerMobile(orderDetails.getCustomerMobile());
	 
	        order.setOrderDate(orderDetails.getOrderDate());
	        
	        final Order updatedOrder = orderRepository.save(order);
	        return ResponseEntity.ok(updatedOrder);
	    }	
	
	
	//delete order
	@DeleteMapping("/orders/{orderId}")
	public ResponseEntity<?> deleteOrder( 
			@PathVariable(value = "orderId") String orderId)
	throws ResourceNotFoundException
	{
		return orderRepository.findById(orderId).map(order -> {
			orderRepository.delete(order);
			Map<String,Boolean> response =new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		}).orElseThrow(()->new ResourceNotFoundException("order not found"));
	}
	
	//get order by orderId
	@GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable(value = "id") String orderId)
        throws ResourceNotFoundException {
        Order order = orderRepository.findById(orderId)
          .orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + orderId));
        
        
        return ResponseEntity.ok().body(order);
    }

}
