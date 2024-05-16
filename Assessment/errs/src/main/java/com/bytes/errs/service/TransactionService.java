package com.bytes.errs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bytes.errs.model.Transaction;

@Service
public interface TransactionService {

	List<Transaction> getTransactionsByUserId(Long userId);

}
