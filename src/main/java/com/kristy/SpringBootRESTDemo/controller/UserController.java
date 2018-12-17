package com.kristy.SpringBootRESTDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kristy.SpringBootRESTDemo.bean.User;
import com.kristy.SpringBootRESTDemo.dao.UserDao;
import com.kristy.SpringBootRESTDemo.http.Response;
import com.kristy.SpringBootRESTDemo.service.UserService;

@RestController("/users")
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	UserService userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping
	public List<User> getUsers(){
		return userDao.findAll();
	}
	
	@PostMapping
	public Response addUser(@RequestBody User user) {
		return userService.register(user);
	}
	
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
	@PutMapping
	public Response changeUser(@RequestBody User user, Authentication authentication) {
		return userService.changePassword(user, authentication);
	}
	
}
