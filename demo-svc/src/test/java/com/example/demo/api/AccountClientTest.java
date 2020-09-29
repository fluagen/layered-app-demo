package com.example.demo.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.example.demo.api.model.AccountModel;
import com.example.demo.service.AccountService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@EnableFeignClients(basePackages = { "com.example.demo.api" })
public class AccountClientTest {

	@MockBean
	AccountService accountService;

	@Autowired
	AccountClient client;

	@Test
	public void testGet() {
		when(accountService.getAccount(1L)).thenReturn(AccountModel.builder()
				.name("xiaoming")
				.email("xiaom@calis.edu.cn")
				.build());

		AccountModel model = client.getAccount(1L);
		assertThat(model)
		.hasFieldOrPropertyWithValue("name", "xiaoming")
		.hasFieldOrPropertyWithValue("email","xiaom@calis.edu.cn");
	}
}
