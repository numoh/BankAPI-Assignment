package com.atlar.fakebankapi.controller;

import com.atlar.fakebankapi.model.Account;
import com.atlar.fakebankapi.service.AccountService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/getAllAccounts")
    @PreAuthorize("hasAuthority('SCOPE_read:accounts')")
    public List<Account> getAccountNumber() {
        return accountService.getAccounts();
    }
}

