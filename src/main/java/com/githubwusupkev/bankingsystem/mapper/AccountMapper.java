package com.githubwusupkev.bankingsystem.mapper;

import com.githubwusupkev.bankingsystem.dto.AccountDto;
import com.githubwusupkev.bankingsystem.entities.Account;

public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto){
        Account account= new Account(
                accountDto.getAccountId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );
        return account;
    }

    public static AccountDto mapToAccountDTO(Account account){
        AccountDto accountDto= new AccountDto(
              account.getAccountId(),
              account.getAccountHolderName(),
              account.getBalance()
        );
        return accountDto;
    }
}
