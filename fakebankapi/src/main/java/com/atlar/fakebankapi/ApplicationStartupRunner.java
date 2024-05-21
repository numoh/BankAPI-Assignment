package com.atlar.fakebankapi;

import com.atlar.fakebankapi.service.AccountService;
import com.atlar.fakebankapi.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartupRunner implements CommandLineRunner {

    @Autowired private AccountService accountService;
    @Autowired private TransactionsService transactionsService;


    @Override
    public void run(String... args) throws Exception {
        System.out.println(accountService.parseAccount());
        System.out.println(transactionsService.parseTransactions());
    }
}
