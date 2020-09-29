package com.example.demo.web;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.api.model.AccountModel;
import com.example.demo.service.AccountService;

@WebMvcTest(AccountController.class)
public class AccountControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	AccountService accountService;

	@Test
	public void testGet() throws Exception {
		
		when(accountService.getAccount(1L)).thenReturn(AccountModel.builder()
				.name("xiaoming")
				.email("xiaom@calis.edu.cn")
				.build());

		mockMvc.perform(get("/account/get").param("id", "1")).andExpect(status().isOk());
	}
}
