package com.kristy.SpringBootRESTDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kristy.SpringBootRESTDemo.bean.Transfer;


public interface TransferDao extends JpaRepository<Transfer, Integer>{
	

}
