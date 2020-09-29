package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.api.model.AccountModel;
import com.example.demo.repo.AccountRepository;
import com.example.demo.repo.dataobject.AccountDO;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

	@Mock
	AccountRepository repo;

	@InjectMocks
	AccountService accountService;

	@Test
	public void testGetAccount() {

		when(repo.getOne(1L)).thenReturn(AccountDO.builder()
				.name("xiaoming")
				.email("xiaom@calis.edu.cn")
				.build());

		AccountModel model = accountService.getAccount(1L);

		assertThat(model)
		.hasFieldOrPropertyWithValue("name", "xiaoming")
		.hasFieldOrPropertyWithValue("email","xiaom@calis.edu.cn");
	}
}


