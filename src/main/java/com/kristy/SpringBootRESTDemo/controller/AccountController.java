package com.kristy.SpringBootRESTDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kristy.SpringBootRESTDemo.bean.Account;
import com.kristy.SpringBootRESTDemo.bean.User;
import com.kristy.SpringBootRESTDemo.dao.AccountDao;
import com.kristy.SpringBootRESTDemo.dao.UserDao;

@RestController
public class AccountController {
	@Autowired
	UserDao userDao;
	@Autowired
	AccountDao accountDao;

	@GetMapping("/checking_account_info")
	public Account getCAccountInfo( Authentication authentication){
	User u = userDao.findByUsername(authentication.getName());
	Account c_account = accountDao.findByAccountnumber(u.getChecking_account());
	return c_account;
	}
	@GetMapping("/saving_account_info")
	public Account getSAccountInfo( Authentication authentication){
	User u = userDao.findByUsername(authentication.getName());
	Account s_account = accountDao.findByAccountnumber(u.getSaving_account());
	return s_account;
	}
	
}
