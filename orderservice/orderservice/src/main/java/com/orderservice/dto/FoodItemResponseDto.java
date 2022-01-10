package com.orderservice.dto;

import lombok.Data;

@Data  
public class FoodItemResponseDto {
	private Integer foodItemId;
	private String foodName;
	private Double price;
	private String foodType;
}
