package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.springboot.entity.Transaction;
import com.springboot.repo.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public boolean dotransaction(Transaction transaction) {
		
		Integer act=transaction.getAccountNumber();
		Integer bal=transaction.getBalance();
		Integer bill=transaction.getBill();
		
		Integer curbal=bal-bill;
		
		if(curbal>=0) {
		transactionRepository.deductFromAcccount(curbal,act);
		transaction.setBalance(curbal);
		System.out.println(curbal);
		transactionRepository.save(transaction);

		return true;
		}else
		return false;
	}

	@Override
	public List<Transaction> getAllTransactions() {
		return transactionRepository.findAll();
		
		}

	@Override
	public List<Transaction> sortByTransactions(String feild) {
		return transactionRepository.findAll(Sort.by(Direction.ASC,feild));
		
	}

	@Override
	public Page<Transaction> findByPagination(int offset, int page) {
		
		return transactionRepository.findAll(PageRequest.of(offset, page));
	}

	
}
