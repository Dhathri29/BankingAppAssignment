package com.bankapp.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bankapp.model.dao.User;
import com.bankapp.model.dao.UserType;
import com.bankapp.model.service.UserService;
import com.bankapp.web.formbeans.UserBean;

@Controller
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("signupuser")
	public String signupUserGet(ModelMap map) {
		map.addAttribute("userBean", new UserBean());
		return "signup";
	}
   
	@PostMapping("signupuser")
	public String SignupUserPost(@Valid @ModelAttribute("userBean") User userBean, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/signup";
		} else {
			userService.addUser(userBean);
		return "redirect:/login";
		}
	}
	
	@GetMapping("adduser")
	public String addUserGet(ModelMap map) {
		map.addAttribute("userBean", new UserBean());
		return "adduser";
	}
	
	@PostMapping("adduser")
	public String addUserPost(@Valid @ModelAttribute("userBean") User userBean, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/adduser";
		} else {
			userService.addUser(userBean);
		return "redirect:/home";
		}
	}
	
	@GetMapping("updateuser")
	public String updateUserGet(ModelMap map) {
		map.addAttribute("userBean", new UserBean());
		return "updateuser";
	}
	
	@PostMapping("updateuser")
	public String updateUserPost(@Valid @ModelAttribute("userBean") User userBean, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/updateuser";
		} else {
			userService.updateUser(userBean);
		return "redirect:/home";
		}
	}
	
	@ModelAttribute(value = "usertypes")
	public UserType[] userType() {
		return UserType.values();
	}

}