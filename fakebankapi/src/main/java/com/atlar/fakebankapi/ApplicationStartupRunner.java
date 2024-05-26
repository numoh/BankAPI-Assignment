package com.atlar.fakebankapi;

import com.atlar.fakebankapi.service.AccountService;
import com.atlar.fakebankapi.service.TransactionsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartupRunner implements CommandLineRunner {

    private final AccountService accountService;
    private final TransactionsService transactionsService;

    public ApplicationStartupRunner(AccountService accountService, TransactionsService transactionsService) {
        this.accountService = accountService;
        this.transactionsService = transactionsService;
    }
    @Override
    public void run(String... args) {
        System.out.println(accountService.parseAccount());
        System.out.println(transactionsService.parseTransactions());
    }
}
