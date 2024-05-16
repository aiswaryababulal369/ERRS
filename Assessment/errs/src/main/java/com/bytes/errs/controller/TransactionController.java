package com.bytes.errs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bytes.errs.model.Transaction;
import com.bytes.errs.service.TransactionService;

@RestController
@RequestMapping(value = "transaction")
@CrossOrigin(origins = "*")
public class TransactionController {
	
	 	@Autowired
	    private TransactionService transactionService;

	    @GetMapping("/user/{userId}")
	    public ResponseEntity<List<Transaction>> getTransactionsByUserId(@PathVariable Long userId) {
	        List<Transaction> transactions = transactionService.getTransactionsByUserId(userId);
	        return ResponseEntity.ok(transactions);
	    }

}
