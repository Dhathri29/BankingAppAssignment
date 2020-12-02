package com.bankapp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bankapp.model.dao.User;
import com.bankapp.model.service.UserService;
import com.bankapp.web.formbeans.LoginBean;

@Controller
public class LoginController {
	
	private UserService userService;
	
	@Autowired
	public LoginController(UserService userService) {
		this.userService = userService;
	}

	
	@GetMapping("/")
	public String home(ModelMap map) {
		map.addAttribute("loginBean", new LoginBean());
		return "login";
	}
	
	@PostMapping("login")
	public String loginPost(@Valid @ModelAttribute("loginBean") LoginBean loginBean, BindingResult result, HttpServletRequest req) {
		
		if(result.hasErrors()) {
			return "login";
		} else {
			HttpSession session = req.getSession();
			String username = loginBean.getUsername();
			String password = loginBean.getPassword();
			User user = userService.getUser(username, password);
			session.setAttribute("user", user);
			System.out.println("---------------------------------------------------------");
			System.out.println(user);
			return "redirect:/home";
		}
	}
	
	@GetMapping("logout")
	public String logout(HttpServletRequest req) {

		HttpSession session = req.getSession(false);
		
		if(session != null) {
			session.invalidate();
		}
		return "redirect:/";
	}
}