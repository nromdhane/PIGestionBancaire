package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Transaction;

public interface ITransactionService {

	public List<Transaction> retrieveAllTransactions();

	public Transaction addTransaction(Transaction tran);

	public void deleteTransaction(Integer id);

	public Transaction updateTransaction(Transaction t);

	public Transaction retrieveTransaction(Integer id);
}
