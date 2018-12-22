package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("accountService")
@Transactional(readOnly = true ,propagation = Propagation.SUPPORTS)
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao ad;
//    public void setAd(AccountDao ad){
//        this.ad=ad;
//    }
    public List<Account> findAll() {
        List<Account> all = ad.findAll();
        return all;
    }

    public void update(Account account) {
            ad.update(account);
    }
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void zhuan(String zhuan, String beizhuan, int jine) {
        Account zhuan1 = ad.findByname(zhuan);
        Account beizhuan1 = ad.findByname(beizhuan);
        zhuan1.setMoney(zhuan1.getMoney()-jine);
        beizhuan1.setMoney(beizhuan1.getMoney()+jine);
        ad.update(zhuan1);
//        int i=1/0;
        ad.update(beizhuan1);
    }


}
