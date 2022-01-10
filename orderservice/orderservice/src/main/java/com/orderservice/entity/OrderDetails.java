package com.orderservice.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class OrderDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderDetailId")
	private Integer orderDetailId;
	private Double totalPrice;
	private String orderNumber;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	@ElementCollection
	private List<FoodWithQuantity> foodList=new ArrayList<FoodWithQuantity>();
	private LocalDateTime date;

}
