package com.itheima.test;

import com.itheima.config.SpringConfig;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class SpringTest {
    @Autowired
    private AccountService as;
//    public void setAs(AccountService as){
//        this.as=as;
//    }
    @Test
    public void findAll(){
        List<Account> all = as.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
    }
    @Test
    public void zhuan(){
        as.zhuan("aaa","bbb",200);
    }
}
