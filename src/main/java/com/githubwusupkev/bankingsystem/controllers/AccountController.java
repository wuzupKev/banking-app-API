package com.githubwusupkev.bankingsystem.controllers;

import com.githubwusupkev.bankingsystem.dto.AccountDto;
import com.githubwusupkev.bankingsystem.entities.Account;
import com.githubwusupkev.bankingsystem.services.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountServiceImpl accountService;

    @PostMapping("/create")
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
       return new ResponseEntity<>(accountService.create(accountDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAcount(@PathVariable Integer id){
        return ResponseEntity.ok(accountService.findById(id));
    }

    @PostMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable int id ,@RequestBody Map<String , Double> req){
       AccountDto accountDto=  accountService.deposit(id,req.get("amount"));
       return ResponseEntity.ok(accountDto);
    }
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable int id ,@RequestBody Map<String , Double> req){
        AccountDto accountDto=  accountService.withdraw(id,req.get("amount"));
        return ResponseEntity.ok(accountDto);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        return ResponseEntity.ok(accountService.getAllAccounts());
    }
}
