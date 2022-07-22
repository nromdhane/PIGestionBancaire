package tn.esprit.spring.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Transaction;
import tn.esprit.spring.service.TransactionServiceImpl;

@RestController
public class TransactionController {

	@Autowired
	TransactionServiceImpl impl;
	
	@GetMapping(value="/retrieve-all-transaction")
	public List<Transaction> getAllTransaction(){
			List<Transaction> list =impl.retrieveAllTransactions();
			System.out.print("list Transaction"+list);
			return list;
	}
	
	@GetMapping(value="/retrieve-transaction/{id}")
	public Transaction getTransaction(@PathVariable("id") Integer id){
			return impl.retrieveTransaction(id);
	}
	
	@PostMapping (value="/save-transaction")
	public Transaction addTransaction(@RequestBody Transaction tran) {
		System.out.print("new transaction"+tran);
		return impl.addTransaction(tran);
	}
	
	@DeleteMapping(value = "/delete-transaction/{id}")
	public void deleteTransaction(@PathVariable("id") Integer id) {
		impl.deleteTransaction(id);
	}
	
	@PostMapping (value="/update-transaction")
	public Transaction updateTransaction(@RequestBody Transaction tran) {
		System.out.print("update transaction"+tran);
		return impl.updateTransaction(tran);
	}
	
	
}
