package com.atlar.fakebankapi.controller;

import com.atlar.fakebankapi.model.Transaction;
import com.atlar.fakebankapi.service.TransactionsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/transactions")
@Tag(name = "Transactions Controller", description = "List transactions for an account")
public class TransactionsController {

    @Autowired private TransactionsService transactionsService;

    @Operation(summary = "List transactions",
        description = "List all transactions for all accounts")
    @GetMapping("/getAllTransactions")
    @PreAuthorize("hasAuthority('SCOPE_read:transactions')")
    public List<Transaction> getAllTransactions() {
        return transactionsService.getTransactions();
    }

    @Operation(summary = "Get transactions",
        description = "Get transactions for a specific account")
    @GetMapping("/getTransactionForAnAccount")
    @PreAuthorize("hasAuthority('SCOPE_read:account-transactions')")
    public List<Transaction> getTransactionsForAccount(@RequestParam String accountName) {
        return transactionsService.getTransactionsForAnAccount(accountName);
    }
}
