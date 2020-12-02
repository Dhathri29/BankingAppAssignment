package com.bankapp.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.dao.Account;
import com.bankapp.model.service.AccountService;
import com.bankapp.web.formbeans.TransferBean;
import com.bankapp.web.formbeans.WithDrawBean;

@Controller
public class TransactionController {
	
	private AccountService accountService;
	
	@Autowired
	public TransactionController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("transfer")
	public String transferGet(ModelMap map) {
		map.addAttribute("transferBean", new TransferBean());
		return "transfer";
	}
	
	@PostMapping("transfer") 
	public String transferPost(@Valid @ModelAttribute("transferBean") TransferBean transferBean, BindingResult result) {
		
		if(result.hasErrors()) {
			return "transfer";
		} else {
		int fromAccountId = transferBean.getFromAccountId();
		int toAccountId = transferBean.getToAccountId();
		Double amount = transferBean.getAmount();
		accountService.transfer(fromAccountId, toAccountId, amount);
		return "success";
		}
	}
	
	@GetMapping("withdraw")
	public String withdrawGet(ModelMap map) {
		map.addAttribute("withdrawBean", new WithDrawBean());
		return "withdraw";
	}
	
	@PostMapping("withdraw") 
	public String withdrawPost(@Valid @ModelAttribute("withdrawBean") WithDrawBean withdrawBean, BindingResult result) {
		if(result.hasErrors()) {
			return "withdraw";
		} else {
		int accountId = withdrawBean.getAccountId();
		Double amount = withdrawBean.getAmount();
		accountService.withdraw(accountId, amount);
		return "success";
		}
	}
	
	@GetMapping("deposit")
	public String depositGet(ModelMap map) {
		map.addAttribute("depositBean", new WithDrawBean());
		return "deposit";
	}
	
	@PostMapping("deposit") 
	public String depositPost(@Valid @ModelAttribute("depositBean") WithDrawBean withdrawBean, BindingResult result) {
		if(result.hasErrors()) {
			return "deposit";
		} else {
		int accountId = withdrawBean.getAccountId();
		Double amount = withdrawBean.getAmount();
		accountService.deposit(accountId, amount);
		return "success";
		}
	}
}