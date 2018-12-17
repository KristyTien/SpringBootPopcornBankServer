package com.kristy.SpringBootRESTDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kristy.SpringBootRESTDemo.bean.Account;
import com.kristy.SpringBootRESTDemo.bean.Mail;
import com.kristy.SpringBootRESTDemo.bean.User;
import com.kristy.SpringBootRESTDemo.bean.UserInfo;
import com.kristy.SpringBootRESTDemo.dao.AccountDao;
import com.kristy.SpringBootRESTDemo.dao.UserDao;
import com.kristy.SpringBootRESTDemo.dao.UserInfoDao;
import com.kristy.SpringBootRESTDemo.http.Response;
import com.kristy.SpringBootRESTDemo.service.UserInfoService;

@RestController
public class UserInfoController {
	
	@Autowired
	UserInfoDao userInfoDao;
	@Autowired
	UserDao userDao;
	@Autowired
	UserInfoService userInfoService;
	@Autowired
	AccountDao accountDao;

	@GetMapping("/user_info")
	public List<UserInfo> getUserInfo(User user, Authentication authentication){
		System.out.println(userDao.findByUsername(authentication.getName()));
		//System.out.println(authentication.);
		return  (List<UserInfo>)userInfoDao.findAll();
	}
	@GetMapping("/user_info1")
	public  UserInfo getOneUserInfo(User user, Authentication authentication){
		System.out.println(userDao.findByUsername(authentication.getName()));
		User u = userDao.findByUsername(authentication.getName());
		int id= u.getId();
		return  userInfoDao.findOne(id);
	}
	@GetMapping("/user_info/{user_id}")
	public UserInfo getOrder(@PathVariable int user_id) {
		System.out.println("get a user_info");
		return userInfoDao.findOne(user_id);
	}
	@PostMapping("/user_info")
	public Response addUserInfo(@RequestBody UserInfo userInfo, Authentication authentication ){
		System.out.println("user_info post~");
		// todo : coyp Usercontroller adduser
		String username= authentication.getName();
		User u = userDao.findByUsername(username);
		int id= u.getId();
		String checking_account = u.getChecking_account();
		String saving_account = u.getSaving_account();
		userInfo.setUser_id(id);
		userInfo.setChecking_account(checking_account);
		userInfo.setSaving_account(saving_account);
		userInfo.setUsername(username);
		Account c_account = new Account();
		Account s_account = new Account();
		c_account.setAccountnumber(u.getChecking_account());
		c_account.setType(1);
		c_account.setUserid(id);
		s_account.setAccountnumber(u.getSaving_account());
		s_account.setType(2);
		s_account.setUserid(id);
		userInfoDao.save(userInfo);
		accountDao.save(c_account);
		accountDao.save(s_account);
		//Mail.send(userInfo.getEmail());
		return userInfoService.addUserInfo(userInfo);
	}

}
