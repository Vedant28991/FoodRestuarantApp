package com.orderservice.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String username;
	private String password;
	private String address;
	private String phoneNo;
	private String emailId;
	
	@OneToMany(mappedBy="user")
	List<OrderDetails> orderDetailsList=new ArrayList<OrderDetails>();

}
