package com.kristy.SpringBootRESTDemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kristy.SpringBootRESTDemo.bean.AccountActivity;

public interface AccountActivityDao extends JpaRepository<AccountActivity, Integer>{
	List<AccountActivity> findByAccountnumber (String accountnumber);
	List<AccountActivity> findById(int id);
}
