package com.kristy.SpringBootRESTDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.kristy.SpringBootRESTDemo.bean.UserInfo;

public interface UserInfoDao extends JpaRepository<UserInfo, Integer> {

//	@Query("")
//	public UserInfo getUserInfoByName();
	UserInfo findByUsername(String username);
	
}
