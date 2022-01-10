package com.orderservice.dto;

import lombok.Data;

@Data
public class FoodWithQuantityRequestDto {
private Integer foodItemId;
private Integer quantity;
}
