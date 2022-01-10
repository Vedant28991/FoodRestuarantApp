package com.springboot.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

	@Modifying
	@Query(value = "update Transaction set balance =:curbal where accountNumber=:act ")
	@Transactional
	void deductFromAcccount(Integer curbal, Integer act);
	
}
