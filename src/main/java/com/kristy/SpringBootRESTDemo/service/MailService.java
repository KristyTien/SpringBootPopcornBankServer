package com.kristy.SpringBootRESTDemo.service;

import org.springframework.stereotype.Service;

import com.kristy.SpringBootRESTDemo.bean.Mail;
import com.kristy.SpringBootRESTDemo.http.Response;

@Service
public class MailService {

    public Response sendEmail(String mail, String body) {
        
        System.out.println("sendEmail works on mailservice");
        // TODO: validation.
        Mail.send(mail, body);
        
        return new Response(true);
    }
}