package com.dio.bankchallenge.service;

import com.dio.bankchallenge.model.Account;
import com.dio.bankchallenge.repositories.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.net.server.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {

  @Autowired
  private AccountRepository accountRepository;

  public List<Account> findAll() {
    return (List<Account>) accountRepository.findAll();
  }

  public Optional<Account> findById(UUID id) {
    Optional<Account> result = accountRepository.findById(id);

    if (result.isEmpty()) {
      throw new RuntimeException("Account not found");
    }

    return result;
  }

  public Account save(Account Account) {
    Client obj = accountRepository.findByClient(Account.getId());
    try {
      if (obj == null) {
        return accountRepository.save(Account);
      } else {
        throw new RuntimeException("This client already has an account.");
      }
    } catch (Exception e) {
      throw new RuntimeException("failure to save Account.");
    }
  }

  public Account update(Account Account) {
    Optional<Account> obj = findById(Account.getId());

    try {
      Account.setId(obj.get().getId());
      return accountRepository.save(Account);
    } catch (Exception e) {
      throw new RuntimeException("failure to update Account.");
    }
  }

  public void delete(UUID id) {
    Optional<Account> obj = findById(id);

    try {
      accountRepository.delete(obj.get());
    } catch (Exception e) {
      throw new RuntimeException("failure to delete Account.");
    }
  }

}
