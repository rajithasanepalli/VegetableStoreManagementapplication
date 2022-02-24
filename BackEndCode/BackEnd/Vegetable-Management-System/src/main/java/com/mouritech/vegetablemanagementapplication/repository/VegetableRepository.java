package com.mouritech.vegetablemanagementapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouritech.vegetablemanagementapplication.model.Vegetable;

@Repository
public interface VegetableRepository extends JpaRepository<Vegetable, Long>{

}
