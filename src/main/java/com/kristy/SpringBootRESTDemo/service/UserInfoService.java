package com.kristy.SpringBootRESTDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kristy.SpringBootRESTDemo.bean.Account;
import com.kristy.SpringBootRESTDemo.bean.UserInfo;
import com.kristy.SpringBootRESTDemo.dao.UserInfoDao;
import com.kristy.SpringBootRESTDemo.http.Response;

@Service
@Transactional
public class UserInfoService {
	@Autowired
	UserInfoDao userInfoDao;
public Response addUserInfo(UserInfo userInfo){
	userInfoDao.save(userInfo);
	return new Response(true);
}

}
