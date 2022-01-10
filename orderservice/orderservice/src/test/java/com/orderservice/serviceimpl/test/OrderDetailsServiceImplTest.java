package com.orderservice.serviceimpl.test;

import com.orderservice.entity.User;
import com.orderservice.dto.OrderDetailsRequestDto;
import com.orderservice.entity.OrderDetails;
import com.orderservice.exception.NotFoundException;
import com.orderservice.repository.OrderDetailsRepository;
import com.orderservice.repository.UserRepository;
import com.orderservice.serviceimpl.OrderDetailsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension .class)
class OrderDetailsServiceImplTest {

    @Mock
    OrderDetailsRepository orderDetailsRepository;

    @Mock
    UserRepository userRepository;

    @InjectMocks
    OrderDetailsServiceImpl orderDetailsServiceImpl;

    OrderDetailsRequestDto orderDetailsRequestDto;

    OrderDetails orderDetails;

    User user;

    OrderDetails saveOrderDetails;

    @BeforeEach
    public void setUp() {

        user =new User();
        user.setUserId(1);
        user.setAddress("nagpur");
        user.setUsername("pasha");
        user.setEmailId("v@hcl.com");

        orderDetailsRequestDto=new OrderDetailsRequestDto();
        orderDetailsRequestDto.setUserId(1);

    }

    @Test
    void saveOrderDetailsDataTest_Positive() {

        Optional<User> optionalUser= Optional.of(user);
        when(userRepository.findById(orderDetailsRequestDto.getUserId())).thenReturn(optionalUser);
        orderDetailsServiceImpl.placeOrder(orderDetailsRequestDto);
        verify(orderDetailsRepository,times(1)).save(any(OrderDetails.class));

    }

    @Test
    void saveOrderDetailsDataTest_Negative () {

        Optional<User> optionalUser=Optional.empty();
        when(userRepository.findById(orderDetailsRequestDto.getUserId())).thenReturn(optionalUser);
        assertThrows(NotFoundException.class, ()->orderDetailsServiceImpl.placeOrder(orderDetailsRequestDto));

    }
}

