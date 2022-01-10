package com.orderservice.controller.test;

import com.orderservice.controller.OrderDetailsController;
import com.orderservice.dto.OrderDetailsRequestDto;
import com.orderservice.service.OrderDetailsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderDetailsControllerTest {

    @Mock
    OrderDetailsService orderDetailsService;

    @InjectMocks
    OrderDetailsController orderDetailsController;

    OrderDetailsRequestDto orderDetailsRequestDto;

    @BeforeEach
    public void setUp() {
        orderDetailsRequestDto=new OrderDetailsRequestDto();
        orderDetailsRequestDto.setUserId(1);
    }

    @Test
    @DisplayName("Save Order Details Data: Positive")
    void saveOrderDetailsDataTest_Positive() {

        //context
        when(orderDetailsService.placeOrder(orderDetailsRequestDto)).thenReturn(true);

        //event
        ResponseEntity<String> result=orderDetailsController.placeOrder(orderDetailsRequestDto);

        //outcome
        assertEquals("Order Placed successfully!!", result.getBody());
        assertEquals(HttpStatus.ACCEPTED, result.getStatusCode());

    }

    @Test
    @DisplayName("Save Order Details Data: Negative")
    void saveOrderDetailsDataTest_Negative() {

        //context
        when(orderDetailsService.placeOrder(orderDetailsRequestDto)).thenReturn(false);

        //event
        ResponseEntity<String> result = orderDetailsController.placeOrder(orderDetailsRequestDto);

        //outcome
        assertEquals("Order not Placed!!", result.getBody());
        assertEquals(HttpStatus.NOT_ACCEPTABLE, result.getStatusCode());
    }

    }
