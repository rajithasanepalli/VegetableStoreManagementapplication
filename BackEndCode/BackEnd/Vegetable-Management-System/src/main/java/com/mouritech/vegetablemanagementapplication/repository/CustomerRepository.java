package com.mouritech.vegetablemanagementapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mouritech.vegetablemanagementapplication.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
