package com.orderservice.entity;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class FoodWithQuantity {
	
	private Integer foodItemId;
	private Integer quantity;

}
