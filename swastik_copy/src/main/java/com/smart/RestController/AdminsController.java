package com.smart.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.dao.AdminsRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminsController {

	@Autowired
	public AdminsRepository adminsRepository;

	// Handler for login
	@RequestMapping("/")
	public String Login(Model model) {

		model.addAttribute("title", "Login - igaptech_Swastik ");

		return "login";
	}
	
	@RequestMapping("/login")
	public String LoginCheck(Model model) {

		model.addAttribute("title", "Login - igaptech_Swastik ");

		return "login";
	}

	// Handler for homepage

	@RequestMapping("/home")
	public String Home(Model model) {

		model.addAttribute("title", "Home -  igaptech_Swastik ");

		return "home";
	}

}
