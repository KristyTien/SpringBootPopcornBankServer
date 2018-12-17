package com.kristy.SpringBootRESTDemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kristy.SpringBootRESTDemo.bean.User;
import com.kristy.SpringBootRESTDemo.dao.UserDao;

@Service
public class UserServiceImpl implements UserDetailsService {
	
	@Autowired
	UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("User " + username + " was not found in the database");
		}
		return user;
	}

}
