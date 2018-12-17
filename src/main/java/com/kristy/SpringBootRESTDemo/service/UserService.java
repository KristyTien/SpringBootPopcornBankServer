package com.kristy.SpringBootRESTDemo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kristy.SpringBootRESTDemo.bean.Account;
import com.kristy.SpringBootRESTDemo.bean.User;
import com.kristy.SpringBootRESTDemo.bean.UserProfile;
import com.kristy.SpringBootRESTDemo.dao.AccountDao;
import com.kristy.SpringBootRESTDemo.dao.UserDao;
import com.kristy.SpringBootRESTDemo.http.Response;

@Service
@Transactional
public class UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AccountDao accountDao;

	public Response register(User user) {
		// TODO: validation.
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		List<UserProfile> profiles = new ArrayList<UserProfile>();
		profiles.add(new UserProfile(2));
		user.setProfiles(profiles);
		userDao.save(user);
		return new Response(true);
	}
	
	public Response changePassword(User user, Authentication authentication) {
		if(user.getUsername().equals(authentication.getName()) || isAdmin(authentication.getAuthorities())) {
			User u = userDao.findByUsername(user.getUsername());
			u.setPassword(passwordEncoder.encode(user.getPassword()));
			userDao.save(u);
		}else {
			//TODO: Not authorize to update password if not current loggedin user or admin.
			return new Response(false);
		}
		return new Response(true);
	}
	
	public boolean isAdmin(Collection<? extends GrantedAuthority> profiles) {
		boolean isAdmin = false;
		for(GrantedAuthority profle: profiles) {
			if(profle.getAuthority().equals("ROLE_ADMIN")) {
				isAdmin = true;
			}
		};
		return isAdmin;
	}

}
