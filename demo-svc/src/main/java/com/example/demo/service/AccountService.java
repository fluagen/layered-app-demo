package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import com.example.demo.api.model.AccountModel;
import com.example.demo.repo.AccountRepository;
import com.example.demo.repo.dataobject.AccountDO;

@Service
public class AccountService {

	@Autowired
	AccountRepository repo;

	private static final BeanCopier copier = BeanCopier.create(AccountDO.class, AccountModel.class, false);
	
	public AccountModel getAccount(Long id) {
		AccountDO accountDO = repo.getOne(id);
		AccountModel accountModel = AccountModel.builder().build();
		copier.copy(accountDO, accountModel, null);
		
		return accountModel;
	}
	
	public AccountModel addAccount(String name, String email) {
		AccountDO accountDO = AccountDO.builder().name(name).email(email).build();
		accountDO = repo.save(accountDO);
		
		AccountModel accountModel = AccountModel.builder().build();
		copier.copy(accountDO, accountModel, null);
		
		return accountModel;
	}
}

