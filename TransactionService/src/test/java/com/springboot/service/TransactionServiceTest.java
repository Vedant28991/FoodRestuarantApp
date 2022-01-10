package com.springboot.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.springboot.entity.Transaction;
import com.springboot.repo.TransactionRepository;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

	@Mock
	TransactionRepository transactionRepository;
	
	@InjectMocks
	TransactionServiceImpl transactionServiceImpl;
	
	Transaction transaction;
	
	@BeforeEach
	public void setUp() {
		transaction=new Transaction();
		transaction.setAccountNumber(1234);
		transaction.setBalance(500);
		transaction.setBill(300);
		transaction.setOrderId(12);
	}
	
	@Test
	public void saveTransaction() {
		//when(customerRepository.save(any(Customer.class))).thenReturn(customer);
		when(transactionRepository.save(any(Transaction.class))).thenReturn(transaction);
		
		//event
		boolean result=transactionServiceImpl.dotransaction(transaction);
		
		assertEquals(true, result);
	}
	
}