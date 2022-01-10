package com.foodapp.java.dto;

import javax.validation.constraints.NotEmpty;

public class MenuRequestDto {

	@NotEmpty(message="foodName required for searching")
	private String foodName;

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	
	
}
