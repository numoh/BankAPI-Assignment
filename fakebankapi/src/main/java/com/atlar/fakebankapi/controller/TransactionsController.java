package com.atlar.fakebankapi.controller;

import com.atlar.fakebankapi.model.Transaction;
import com.atlar.fakebankapi.service.TransactionsService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {

    private final TransactionsService transactionsService;

    public TransactionsController(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @GetMapping("/getAllTransactions")
    @PreAuthorize("hasAuthority('SCOPE_read:transactions')")
    public List<Transaction> getAllTransactions() {
        return transactionsService.getTransactions();
    }

    @GetMapping("/getTransactionForAnAccount")
    @PreAuthorize("hasAuthority('SCOPE_read:account-transactions')")
    public List<Transaction> getTransactionsForAccount(@RequestParam String accountName) {
        return transactionsService.getTransactionsForAnAccount(accountName);
    }
}
