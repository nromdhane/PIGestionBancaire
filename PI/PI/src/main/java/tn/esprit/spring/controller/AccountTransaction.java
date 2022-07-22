package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.spring.entity.Utilisateur;
import tn.esprit.spring.controller.CommonController;
import tn.esprit.spring.util.Constants;
import tn.esprit.spring.entity.Compte;
import tn.esprit.spring.entity.Transaction;
import tn.esprit.spring.exception.SoftIBBadRequestException;
import tn.esprit.spring.util.SystemMessages;
import tn.esprit.spring.service.AccountService;
import tn.esprit.spring.exception.SoftIBObjectNotFoundException; 
public class AccountTransaction extends CommonController{
    @Autowired
    AccountService accountService;
    @GetMapping(Constants.URI_API_ACCOUNT_TRANSACTION)
    /*   public ResponseEntity<?> getAccountTransactions(@PathVariable(Constants.PATH_VARIABLE_ID) Long id) {

        Utilisateur authUser = getAuthenticatedUser();
        Compte account = getAccountById(id);

      if (!(account.getUtilisateur().getId() == authUser.getId())) {
            throw new SoftIBForbiddenException(SystemMessages.ACCESS_FORBIDDEN);

        }

        return ResponseEntity.ok(account.getAcountTransactionList());
        
    }*/
    

    public Compte getAccountById(Long id) {
        if (id < 0) {
            throw new SoftIBBadRequestException(SystemMessages.INVALID_OBJECT_ID);
        }
        Compte account = accountService.getAccountById(id);
        if (account == null) {
            throw new SoftIBObjectNotFoundException(SystemMessages.OBJECT_NOT_FOUND + id);
        }
        return account;
    }


}
