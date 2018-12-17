package com.kristy.SpringBootRESTDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kristy.SpringBootRESTDemo.bean.Account;
import com.kristy.SpringBootRESTDemo.bean.AccountActivity;
import com.kristy.SpringBootRESTDemo.bean.Transfer;
import com.kristy.SpringBootRESTDemo.bean.User;
import com.kristy.SpringBootRESTDemo.dao.AccountActivityDao;
import com.kristy.SpringBootRESTDemo.dao.AccountDao;
import com.kristy.SpringBootRESTDemo.dao.TransferDao;
import com.kristy.SpringBootRESTDemo.dao.UserDao;
import com.kristy.SpringBootRESTDemo.http.Response;

@RestController
public class AccountActivityController {
	
	@Autowired
	UserDao userDao;
	@Autowired
	AccountActivityDao accountActivityDao;
	@Autowired
	AccountDao accountDao;
	@Autowired
	TransferDao transferDao;
	
	
	@GetMapping("/checking_account_activity")
	public List<AccountActivity> getCheckingActivity( Authentication authentication){
		//List<AccountActivity> c = accountActivityDao.findAll();
		User u = userDao.findByUsername(authentication.getName());
		List<AccountActivity> c = accountActivityDao.findByAccountnumber(u.getChecking_account());
		System.out.println(c);
		return c;		
	}
	@GetMapping("/saving_account_activity")
	public List<AccountActivity> getSavingActivity( Authentication authentication){
		//List<AccountActivity> c = accountActivityDao.findAll();
		User u = userDao.findByUsername(authentication.getName());
		List<AccountActivity> s = accountActivityDao.findByAccountnumber(u.getSaving_account());
		return s;		
	}
	@PostMapping("/withdraw")
	public Response withdraw(Authentication authentication, @RequestBody AccountActivity accountactivity){
		Account a = accountDao.findByAccountnumber(accountactivity.getAccountnumber());
		java.util.Date today = new java.util.Date();
		java.sql.Date d =new java.sql.Date(today.getTime());
		float withdrawamonut = accountactivity.getAmount();
		accountactivity.setDescription("withdraw");
		accountactivity.setCategory("cash-withdraw");
		accountactivity.setTimestamp(d);
		accountactivity.setPre_balance(a.getBalance());
		a.setBalance(a.getBalance()- accountactivity.getAmount());
		accountactivity.setAmount(-withdrawamonut);
		accountDao.save(a);
		accountactivity.setPost_balance(a.getBalance());
		accountActivityDao.save(accountactivity);
		return new Response(true);
	}
	@PostMapping("/deposit")
	public Response deposit(Authentication authentication, @RequestBody AccountActivity accountactivity){
		Account a = accountDao.findByAccountnumber(accountactivity.getAccountnumber());
		java.util.Date today = new java.util.Date();
		java.sql.Date d =new java.sql.Date(today.getTime());
		accountactivity.setTimestamp(d);
		accountactivity.setDescription("deposit");
		accountactivity.setCategory("cash-deposit");
		accountactivity.setPre_balance(a.getBalance());
		a.setBalance(a.getBalance()+ accountactivity.getAmount());
		accountDao.save(a);
		accountactivity.setPost_balance(a.getBalance());
		accountActivityDao.save(accountactivity);
		return new Response(true);
	}
	@PostMapping("/transfer")
	public Response transfer(Authentication authentication, @RequestBody Transfer transfer){
		//User u = userDao.findByUsername(authentication.getName());
		Account afrom = accountDao.findByAccountnumber(transfer.getFromaccount());
		Account ato = accountDao.findByAccountnumber(transfer.getToaccount());
		System.out.println(transfer);
		AccountActivity aafrom = new AccountActivity();
		AccountActivity aato = new AccountActivity();
		aafrom.setAccountnumber(transfer.getFromaccount());
		aafrom.setAmount(-transfer.getAmount());
		aato.setAccountnumber(transfer.getToaccount());
		aato.setAmount(transfer.getAmount());
		java.util.Date today = new java.util.Date();
		java.sql.Date d =new java.sql.Date(today.getTime());
		aafrom.setTimestamp(d);
		aato.setTimestamp(d);
		afrom.setBalance(afrom.getBalance() - transfer.getAmount());
		ato.setBalance(ato.getBalance()+transfer.getAmount());
		aafrom.setDescription("transfer to: " + transfer.getToaccount());
		aato.setDescription("Transfer from: " + transfer.getFromaccount());
		aafrom.setCategory("transfer");
		aato.setCategory("transfer");
		accountDao.save(afrom);
		accountDao.save(ato);
		accountActivityDao.save(aafrom);
		accountActivityDao.save(aato);
		//transferDao.save(transfer);
		return new Response(true);
	}

}
