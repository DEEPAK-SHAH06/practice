package com.bway.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bway.springproject.utils.MailUtils;

import jakarta.servlet.http.HttpSession;

@Controller
public class ContactController {

	@Autowired
	private MailUtils mailUtils;
	
	@GetMapping("/contact")
	public String getContactForm(HttpSession session) {
		if(session.getAttribute("activeuser")==null) {
			return "LoginForm";
		}
		return "ContactForm";
	}
	
	@PostMapping("/contact")
	public String postContact(@RequestParam("email") String email,@RequestParam("subject") String subject,@RequestParam("message") String message,Model model) {
		
		mailUtils.sendEmail(email, subject, message);
		model.addAttribute("message","email send success");
		return "ContactForm";
	}
}
