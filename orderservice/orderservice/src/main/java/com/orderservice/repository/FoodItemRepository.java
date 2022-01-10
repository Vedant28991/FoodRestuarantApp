package com.orderservice.repository;

import com.orderservice.entity.FoodItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodItemRepository extends CrudRepository<FoodItem, Integer> {
	List<FoodItem> findByFoodNameContaining(String search);
}
