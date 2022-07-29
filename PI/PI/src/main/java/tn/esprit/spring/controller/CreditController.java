package tn.esprit.spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entity.Credit;
import tn.esprit.spring.service.impl.CreditServiceImpl;

@RestController
public class CreditController {
	
	
	@Autowired
	private CreditServiceImpl creditService;
	
	@GetMapping("/retrieve-all-credits")
	public List<Credit> retrieveAllCredits() {
	 
		return creditService.retrieveAllCredits();
	}

	@GetMapping("/retrieve-credit/{credit-id}")
	public Credit retrieveCredit(@PathVariable("credit-id") Long creditId) {
		return creditService.retrieveCredit(creditId);
	}

	@PostMapping("/add-credit")
	public Credit addCredit(@RequestBody Credit cr) {
		Credit credit = creditService.addCredit(cr);
		return credit;
	}

	@DeleteMapping("/remove-credit/{credit-id}")
	public void deleteCredit(@PathVariable("credit-id") Long  creditId) {
		creditService.deleteCredit(creditId);
	}

	@PutMapping("/update-credit/{credit-id}")
	public Credit updateCredit(@RequestBody Credit credit ,@PathVariable("credit-id") Long  creditId) {
		return creditService.updateCredit(credit, creditId);
	}
	

}