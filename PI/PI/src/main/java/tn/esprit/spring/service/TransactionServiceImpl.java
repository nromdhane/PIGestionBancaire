package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Transaction;
import tn.esprit.spring.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements ITransactionService {
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Override
	public List<Transaction> retrieveAllTransactions(){
		return(List<Transaction>) transactionRepository.findAll();
		
	}

	@Override
	public Transaction addTransaction(Transaction tran) {
		return transactionRepository.save(tran);
	}

	@Override

public void deleteTransaction(Integer id) {
		transactionRepository.deleteById(id);
	}

	@Override
	public Transaction updateTransaction(Transaction t) {
		return transactionRepository.save(t);
	}

	@Override
	public Transaction retrieveTransaction(Integer id) {
		Optional<Transaction> transaction = transactionRepository.findById(id);
		return transaction.orElse(null);
	}
	
	
	


}
