package com.githubwusupkev.bankingsystem.services.impl;

import com.githubwusupkev.bankingsystem.dto.AccountDto;
import com.githubwusupkev.bankingsystem.entities.Account;
import com.githubwusupkev.bankingsystem.mapper.AccountMapper;
import com.githubwusupkev.bankingsystem.repositories.AccountRepository;
import com.githubwusupkev.bankingsystem.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public AccountDto create(AccountDto accountDto) {
        Account account =AccountMapper.mapToAccount(accountDto);
        Account saveAcc= accountRepository.save(account);
        return AccountMapper.mapToAccountDTO(saveAcc) ;
    }

    @Override
    public AccountDto findById(int id) {
        return AccountMapper.mapToAccountDTO(accountRepository.findById(id).orElseThrow(()->new RuntimeException("account doesnt exist"))) ;
    }

    @Override
    public AccountDto deposit(Integer id, double amount) {
        Account account= accountRepository.findById(id).orElseThrow(()->new RuntimeException("account doesnt exist"));
        account.setBalance(account.getBalance()+amount);
        Account acc=accountRepository.save(account);

        return AccountMapper.mapToAccountDTO(acc);
    }

    @Override
    @Transactional
    public AccountDto withdraw(Integer id, double amount) {
        Account account= accountRepository.findById(id).orElseThrow(()->new RuntimeException("account doesnt exist"));

        if (amount>account.getBalance()){
            new RuntimeException("not enough  money in the account");
        }
        else {
            account.setBalance(account.getBalance()-amount);
        }

        Account acc=accountRepository.save(account);

        return AccountMapper.mapToAccountDTO(acc);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return  accounts.stream().map((account)->AccountMapper.mapToAccountDTO(account)).collect(Collectors.toList());

    }
}
