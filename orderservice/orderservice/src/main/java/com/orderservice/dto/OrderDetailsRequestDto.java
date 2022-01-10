package com.orderservice.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderDetailsRequestDto {
private Integer userId;
private List<FoodWithQuantityRequestDto> list = new ArrayList<FoodWithQuantityRequestDto>();
}
