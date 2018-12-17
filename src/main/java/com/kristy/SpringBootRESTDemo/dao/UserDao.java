package com.kristy.SpringBootRESTDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kristy.SpringBootRESTDemo.bean.User;

//@RestResource(path="users", rel="users")
public interface UserDao  extends JpaRepository<User, Integer>{
	User findByUsername(String username);
}
