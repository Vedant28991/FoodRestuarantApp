package com.springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Transaction;
import com.springboot.service.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	
	@PostMapping("/transaction")
	public ResponseEntity<String> transaction(@Valid @RequestBody Transaction transaction){
		
		boolean done=transactionService.dotransaction(transaction);
		if(done) {
		return new ResponseEntity<String>("Transaction Successful",HttpStatus.ACCEPTED);
		}else
		return new ResponseEntity<String>("Something went wrong",HttpStatus.BAD_REQUEST);
		
	}
	 
	@GetMapping("/transactions")
	public ResponseEntity<List<Transaction>> getAllTransactions(){
		
		List<Transaction> allTransactions=transactionService.getAllTransactions();
		
		return new ResponseEntity<List<Transaction>>(allTransactions,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/sort/{feild}")
	public ResponseEntity<List<Transaction>> sortByTransaction(@PathVariable String feild){
		
		List<Transaction>sorted=transactionService.sortByTransactions(feild);
		
		return new ResponseEntity<List<Transaction>>(sorted,HttpStatus.CREATED);
		
	}
	
	@GetMapping("transaction/{offset}/{page}")
	public Page<Transaction> pagination(@PathVariable int offset,@PathVariable int page) {
		
		return transactionService.findByPagination(offset,page);
		
	}
	
	
}
