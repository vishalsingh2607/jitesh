package com.mobileprogramming.ats.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mobileprogramming.ats.model.Login;

@Controller
@RequestMapping("/user")
public class CheckController {

	@GetMapping("/login")
	public String displayLogin(Model model)
	{
		Login login=new Login();
		model.addAttribute("log",login);
		return "user";
		
	}
	@PostMapping("/login")
	public String processLogin(@Valid @ModelAttribute("user")Login login,Model model,Errors error)
	{
		if(error.hasErrors())
		{
			return "user";
		}
		return "home";
		
	}
}
