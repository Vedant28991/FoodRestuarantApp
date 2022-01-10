package com.orderservice.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDetailsResponseDto {

	private Integer orderDetailId;
	private Double totalPrice;
	private LocalDateTime date;

}
