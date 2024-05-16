package com.bytes.errs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bytes.errs.model.Transaction;

@Repository
public interface TransactionDao extends JpaRepository<Transaction, Long>{

	List<Transaction> findByUserUserId(Long userId);
	
	
}
