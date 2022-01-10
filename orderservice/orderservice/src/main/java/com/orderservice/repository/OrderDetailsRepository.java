package com.orderservice.repository;

import com.orderservice.entity.OrderDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends CrudRepository<OrderDetails, Integer> {

	List<OrderDetails> findByUserUserId(Integer userId);
}
