package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

public interface AccountDao {
List<Account> findAll();
void update(Account account);
Account findByname(String name);
}
