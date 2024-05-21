package com.atlar.fakebankapi.controller;

import com.atlar.fakebankapi.model.Account;
import com.atlar.fakebankapi.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/accounts")
@Tag(name = "Account Controller", description = "Get and List accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Operation(summary = "List all accounts",
        description = "Get or list all accounts")
    @GetMapping("/getAllAccounts")
    @PreAuthorize("hasAuthority('SCOPE_read:accounts')")
    public List<Account> getAccountNumber() {
        return accountService.getAccounts();
    }
}

