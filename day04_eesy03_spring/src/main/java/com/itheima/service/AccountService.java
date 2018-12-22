package com.itheima.service;

import com.itheima.domain.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();
    void update(Account account);
    void zhuan(String zhuan, String beizhuan, int jine);
}
