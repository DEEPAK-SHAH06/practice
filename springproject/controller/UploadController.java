package com.bway.springproject.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;

@Controller
public class UploadController {
	
	@GetMapping("/upload")
	public String getUploadForm(HttpSession session) {
		if(session.getAttribute("activeuser")==null) {
			return "LoginForm";
		}
		return "Upload";
	}
	
	@PostMapping("/upload")
	public String postUpload(@RequestParam("file") MultipartFile image, Model model) throws IOException {
		if(!image.isEmpty()) {
			Files.copy(image.getInputStream(), Path.of("src/main/resources/static/images/"+image.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
			model.addAttribute("message","upload success");
			return "Upload";
		}
		model.addAttribute("message","Upload failed");
		return "Upload";
	}

}
