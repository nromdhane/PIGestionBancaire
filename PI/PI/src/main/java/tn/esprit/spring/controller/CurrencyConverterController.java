package tn.esprit.spring.controller;

import java.math.BigDecimal;

import javax.money.MonetaryAmount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.service.CurrencyConverterService;

@RestController
@RequestMapping(value = "/api/converter")
public class CurrencyConverterController {

    @Autowired
    CurrencyConverterService currencyConverterService;
    
    @PostMapping(value = "/convert")
    @ResponseBody
    public MonetaryAmount convert(@RequestParam String currentCurrency, @RequestParam String targetCurrency, @RequestParam BigDecimal amount) {
        return currencyConverterService.convert(currentCurrency, targetCurrency, amount);
    }
	
}
