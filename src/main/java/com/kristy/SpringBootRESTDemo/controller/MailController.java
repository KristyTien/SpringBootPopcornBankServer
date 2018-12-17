package com.kristy.SpringBootRESTDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kristy.SpringBootRESTDemo.bean.Mail;
import com.kristy.SpringBootRESTDemo.bean.User;
import com.kristy.SpringBootRESTDemo.bean.UserInfo;
import com.kristy.SpringBootRESTDemo.dao.UserDao;
import com.kristy.SpringBootRESTDemo.dao.UserInfoDao;
import com.kristy.SpringBootRESTDemo.http.Response;
import com.kristy.SpringBootRESTDemo.service.MailService;


@RestController
public class MailController {
	@Autowired
	UserDao userDao;
	@Autowired
	UserInfoDao userInfoDao;
	@Autowired
    MailService mailService;
	
	 @GetMapping("/register_success_mail")
	 public Response sendEaml(Authentication authentication){
		 System.out.println("sendEmail works on mailcontroller");
		 User u = userDao.findByUsername(authentication.getName());
		 int id= u.getId();
		 UserInfo ui = userInfoDao.findOne(id);
		 String body1 = "<div style=' color:#222;'> <table align='center' border='0' cellspacing='0' cellpadding='0' width='600'>";
		 String body2 = "<tbody style=' color:#222;'> <tr><td valign='top' width='61'><img src='https://s3.amazonaws.com/msi-final-135/flushing-bank-logo-black.png' style='width:200px'/></td></tr>";
		 String body3 = "<tr><td>Dear " + ui.getFirstname()+",</td></tr>";
		 String body4 = "<tr><td>Thank you for choosing Flushing Bank.</td> </tr> <tr><td>We have received your application. </td> </tr>";
		 String body5 = "<tr><td>You checking and saving accounts have been successfully opened.</td></tr> <tr><td>To check your accounts information, please visit our website.  </td></tr>";
		 String body6 = "<tr><td>We look forward to having the opportunity to serve you.</td></tr><tr><td height='30'></td></tr>";
		 String body7 = "<tr style='font-size:10'><td>© 2017 Flushing Bank, N.A</td></tr> <tr style='font-size:10'><td>All rights reserved.</td></tr> </tbody> </table></div> ";
		 String body = body1 + body2 + body3 + body4 + body5 + body6 + body7;
		 //System.out.println(ui.getEmail());
		 //System.out.println(body);
		 //ui.getChecking_account(),ui.getSaving_account()
	     return mailService.sendEmail(ui.getEmail(), body);
	 }
}
