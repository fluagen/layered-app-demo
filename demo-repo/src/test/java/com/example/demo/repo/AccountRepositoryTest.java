package com.example.demo.repo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.demo.repo.dataobject.AccountDO;

@DataJpaTest
public class AccountRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private AccountRepository accountRepo;

	@Test
	public void testFindAll() {
		AccountDO account = AccountDO.builder()
				.name("xiaoming")
				.email("xiaom@calis.edu.cn")
				.build();
		entityManager.persist(account);

		List<AccountDO> list = accountRepo.findAll();

		assertThat(list).extracting(AccountDO::getName).containsOnly(account.getName());
	}
}