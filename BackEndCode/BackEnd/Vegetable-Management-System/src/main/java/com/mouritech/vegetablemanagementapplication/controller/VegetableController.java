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
import com.mouritech.vegetablemanagementapplication.model.Vegetable;
import com.mouritech.vegetablemanagementapplication.repository.VegetableRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController 
@RequestMapping("/api/v1")
public class VegetableController {
	
	@Autowired
	private VegetableRepository repository;
	
	//create an vegetable
	@PostMapping("/vegetable")
	public Vegetable saveOrder(@Valid @RequestBody Vegetable vegetable) {
		return repository.save(vegetable);
	}
	
	//get all vegetables
	@GetMapping("/vegetables")
	public List<Vegetable> getAllVegetables() {
		return repository.findAll();
	}
	
	//update vegetable
	@PutMapping("/vegetable/{id}")
	public ResponseEntity<Vegetable> updateVegetable(@PathVariable(value="id") Long vegId,
	         @Valid @RequestBody Vegetable newVegetable) throws ResourceNotFoundException {
	        Vegetable vegetable = repository.findById(vegId)
	        .orElseThrow(() -> new ResourceNotFoundException("Vegetable not found for this id :: " + vegId));

	        vegetable.setVegName(newVegetable.getVegName());
	        vegetable.setPrice(newVegetable.getPrice());
	        vegetable.setQuantity(newVegetable.getQuantity());
	        vegetable.setSellerId(newVegetable.getSellerId());
	        
	        final Vegetable updatedVegetable = repository.save(vegetable);
	        return ResponseEntity.ok(updatedVegetable);
	    }	
	
	
	//delete vegetable
	@DeleteMapping("/vegetable/{id}")
	public ResponseEntity<?> deleteVegetable( 
			@PathVariable(value="id") Long vegId)
	throws ResourceNotFoundException
	{
		return repository.findById(vegId).map(vegetable -> {
			repository.delete(vegetable);
			Map<String,Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		}).orElseThrow(()->new ResourceNotFoundException("vegetable not found"));
	}
	
	//get vegetable by vegId
	@GetMapping("/vegetable/{id}")
    public ResponseEntity<Vegetable> getVegetableById(@PathVariable(value="id") Long vegId)
        throws ResourceNotFoundException {
        Vegetable vegetable = repository.findById(vegId)
          .orElseThrow(() -> new ResourceNotFoundException("Vegetable not found for this id :: " + vegId));     
        
        return ResponseEntity.ok().body(vegetable);
    }

}
