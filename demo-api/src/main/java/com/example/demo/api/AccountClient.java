package com.example.demo.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.api.model.AccountModel;
import com.example.demo.api.model.CreateAccountRequest;

@FeignClient(name = "account-service", path = "/account", url="http://localhost:8080")
public interface AccountClient {

	@GetMapping("/get")
	AccountModel getAccount(@RequestParam("id") Long id);
	
	@PostMapping("/create")
	AccountModel createAccount(CreateAccountRequest request);
	
}
