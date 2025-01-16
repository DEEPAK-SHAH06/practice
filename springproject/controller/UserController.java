package com.bway.springproject.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bway.springproject.model.User;
import com.bway.springproject.repository.ProductRepository;
import com.bway.springproject.service.UserService;
import com.bway.springproject.utils.VerifyRecaptcha;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductRepository prodRepo;
	
	@GetMapping("/")
	public String getIndex(Model model) {
		model.addAttribute("plist",prodRepo.findAll());
		return "CustomerHome";
	}
	@GetMapping("/login")
	public String getLogin() {
		
		log.info("---inside login form----");
		return "LoginForm";
	}
	@PostMapping("/login")
	public String postLogin(@ModelAttribute User u, Model model ,HttpSession session,@RequestParam("g-recaptcha-response") String grCode) throws IOException {
		
		if(VerifyRecaptcha.verify(grCode)) {
			
			u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
			User usr = userService.userLogin(u.getUsername(),u.getPassword());
			
			if (usr!=null) {
				
				log.info("---login success----");
				session.setAttribute("activeuser", usr);
				session.setMaxInactiveInterval(300);//session expire after 300s
				//model.addAttribute("username",usr.getUsername());
				if(usr.getRole().equalsIgnoreCase("CUSTOMER")) {
					model.addAttribute("plist",prodRepo.findAll());
					return "CustomerHome";
				}
				return "Home";
			}else{
				log.info("---login failed---");
				model.addAttribute("message","User Not Found");
				return "LoginForm";
		    }
		}
			model.addAttribute("message","You are Robot");
			return "LoginForm";
	}
	
	@GetMapping("/signup")
	public String getSignup(HttpSession session) {
//		if(session.getAttribute("activeuser")==null) {
//			return "LoginForm";
//		}
		return "SignupForm";
	}
	
	@PostMapping("/signup")
	public String postSignUp(@ModelAttribute User u) {
		
		u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
		userService.userSignup(u);
		return "SignupForm";
	}

	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "LoginForm";	
	}
	
	
	
	@GetMapping("/gallery")
	public String getGallery(Model model,HttpSession session) {
		if(session.getAttribute("activeuser")==null) {
			return "LoginForm";
		}
		String[] imgName=new File("src/main/resources/static/images").list();
		model.addAttribute("imgName",imgName);
		
		return "GalleryForm";
		
	}	
	
	
	@GetMapping("/productGallery")
	public String getProductGallery(Model model) {
		
		model.addAttribute("plist",prodRepo.findAll());
		return "ProductGalleryForm";
	}
	

	
	
	
	@GetMapping("/profile")
	public String getProfile(HttpSession session) {
		if(session.getAttribute("activeuser")==null) {
			return "LoginForm";
		}
		return "Profile";
	}
}
