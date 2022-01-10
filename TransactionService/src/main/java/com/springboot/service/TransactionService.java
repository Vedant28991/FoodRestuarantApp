package com.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.springboot.entity.Transaction;

public interface TransactionService {


	boolean dotransaction(Transaction transaction);

	List<Transaction> getAllTransactions();

	List<Transaction> sortByTransactions(String feild);

	Page<Transaction> findByPagination(int offset, int page);

	

}
