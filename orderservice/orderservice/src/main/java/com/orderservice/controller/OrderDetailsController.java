package com.orderservice.controller;

import com.orderservice.dto.OrderDetailsRequestDto;
import com.orderservice.dto.OrderDetailsResponseDto;
import com.orderservice.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderDetailsController {
	
	
	@Autowired
	OrderDetailsService orderDetailsService;
	
	@PostMapping("/order")
	public ResponseEntity<String> placeOrder(@RequestBody OrderDetailsRequestDto orderDetailsRequestDto) {
		boolean response=orderDetailsService.placeOrder(orderDetailsRequestDto);
		if(response) {
			return new ResponseEntity<> ("Order Placed successfully!!",HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<> ("Order not Placed!!",HttpStatus.NOT_ACCEPTABLE);
		}

	}

	@GetMapping("/order/{userId}")
	public List<OrderDetailsResponseDto> showHistory(@PathVariable Integer userId){
	return orderDetailsService.showHistory(userId);
	}
}
