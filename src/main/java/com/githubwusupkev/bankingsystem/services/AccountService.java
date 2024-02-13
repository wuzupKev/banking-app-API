package com.githubwusupkev.bankingsystem.services;

import com.githubwusupkev.bankingsystem.dto.AccountDto;
import com.githubwusupkev.bankingsystem.entities.Account;

import java.util.List;

public interface AccountService {
    AccountDto create(AccountDto account);
    AccountDto findById(int id);
    AccountDto deposit(Integer id,double amount);
    AccountDto withdraw(Integer id,double amount);
    List<AccountDto> getAllAccounts();
}
