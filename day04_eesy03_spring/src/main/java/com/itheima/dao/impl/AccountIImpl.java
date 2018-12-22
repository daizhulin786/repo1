package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao")
public class AccountIImpl  implements AccountDao {
    @Autowired
    private JdbcTemplate template;

    public List<Account> findAll() {
        List<Account> query = template.query("SELECT * FROM account ", new BeanPropertyRowMapper<Account>(Account.class));
        return query;
    }

    public void update(Account account) {
        template.update("UPDATE account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
    }

    public Account findByname(String name) {
        Account account = template.queryForObject("SELECT * FROM account WHERE name=?", new BeanPropertyRowMapper<Account>(Account.class), name);
        return account;
    }
}
