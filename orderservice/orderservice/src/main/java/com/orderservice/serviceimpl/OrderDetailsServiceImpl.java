package com.orderservice.serviceimpl;

import com.orderservice.dto.FoodWithQuantityRequestDto;
import com.orderservice.dto.OrderDetailsRequestDto;
import com.orderservice.dto.OrderDetailsResponseDto;
import com.orderservice.entity.FoodItem;
import com.orderservice.entity.FoodWithQuantity;
import com.orderservice.entity.OrderDetails;
import com.orderservice.entity.User;
import com.orderservice.exception.NotFoundException;
import com.orderservice.repository.FoodItemRepository;
import com.orderservice.repository.OrderDetailsRepository;
import com.orderservice.repository.UserRepository;
import com.orderservice.service.OrderDetailsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

	@Autowired
	OrderDetailsRepository orderDetailsRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	FoodItemRepository foodItemRepository;

	@Override
	public boolean placeOrder(OrderDetailsRequestDto orderDetailsRequestDto) {

		OrderDetails order = new OrderDetails();
		Integer id = orderDetailsRequestDto.getUserId();
		Optional<User> userChecked = userRepository.findById(id);

		if(userChecked.isEmpty()) throw new NotFoundException("User doesn't exist for the id "+
				orderDetailsRequestDto.getUserId()+" or you enter wrong id please enter proper id");

		User user=userRepository.findById(id).get();
		order.setUser(user);

		long timeMillis = System.currentTimeMillis();
		long timeSeconds = TimeUnit.MILLISECONDS.toSeconds(timeMillis);
		order.setOrderNumber(timeSeconds + "");

		List<FoodWithQuantityRequestDto> eList = orderDetailsRequestDto.getList();

		List<FoodWithQuantity> list = order.getFoodList();
		Double totalCost = 0.0;

		for (FoodWithQuantityRequestDto fq : eList) {

			FoodItem foodItem = foodItemRepository.findById(fq.getFoodItemId()).get();

			Double itemCost = foodItem.getPrice() * fq.getQuantity();
			totalCost = totalCost + itemCost;

			FoodWithQuantity foodWithQuantity = new FoodWithQuantity();

			BeanUtils.copyProperties(fq, foodWithQuantity);

			list.add(foodWithQuantity);
		}

		order.setTotalPrice(totalCost);
		order.setDate(LocalDateTime.now());
		var response=orderDetailsRepository.save(order);
		if(ObjectUtils.isEmpty(response)) {
			return false;
		}else {
			return true;
		}

	}

	@Override
	public List<OrderDetailsResponseDto> showHistory(Integer userId) {
		Iterator<OrderDetails>orderIterator=orderDetailsRepository.findByUserUserId(userId).iterator();

		List<OrderDetailsResponseDto> hList=new ArrayList<OrderDetailsResponseDto>();

		while(orderIterator.hasNext()) {

		OrderDetails or=orderIterator.next();
		OrderDetailsResponseDto orderDetailsResposeDto=new OrderDetailsResponseDto();
		BeanUtils.copyProperties(or, orderDetailsResposeDto);
		hList.add(orderDetailsResposeDto);
		}

		return hList;
	}

}
