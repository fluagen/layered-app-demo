package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.model.AccountModel;
import com.example.demo.api.model.CreateAccountRequest;
import com.example.demo.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountService accountService;

	@GetMapping("/get")
	public AccountModel getAccount(@RequestParam("id") Long id) {

		AccountModel model = accountService.getAccount(id);
		
		return model;
	}
	
	@PostMapping("/create")
	public AccountModel createAccount(@RequestBody CreateAccountRequest request) {
		
		AccountModel model = accountService.addAccount(request.getName(), request.getEmail());
		
		return model;
	}
}
