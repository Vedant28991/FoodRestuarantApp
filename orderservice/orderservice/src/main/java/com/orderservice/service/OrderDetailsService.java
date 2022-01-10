package com.orderservice.service;

import com.orderservice.dto.OrderDetailsRequestDto;
import com.orderservice.dto.OrderDetailsResponseDto;

import java.util.List;

public interface OrderDetailsService {

	boolean placeOrder(OrderDetailsRequestDto orderDetailsRequestDto);

	List<OrderDetailsResponseDto> showHistory(Integer userId);
}
