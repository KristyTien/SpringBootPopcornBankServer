package com.kristy.SpringBootRESTDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kristy.SpringBootRESTDemo.bean.Account;

public interface AccountDao extends JpaRepository<Account, Integer>{
	Account findByAccountnumber (String accountnumber);
}
