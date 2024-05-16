package com.bytes.errs.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytes.errs.dao.TransactionDao;
import com.bytes.errs.model.Transaction;
import com.bytes.errs.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
    private TransactionDao transactionRepository;

	@Override
    public List<Transaction> getTransactionsByUserId(Long userId) {
        List<Transaction> allTransactions = transactionRepository.findAll();
        return filterTransactionsByUserId(allTransactions, userId);
    }

    private List<Transaction> filterTransactionsByUserId(List<Transaction> transactions, Long userId) {
        return transactions.stream()
                .filter(transaction -> transaction.getUser().getUserId().equals(userId))
                .collect(Collectors.toList());
    }

}
