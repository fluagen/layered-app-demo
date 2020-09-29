package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.repo.dataobject.AccountDO;

public interface AccountRepository extends JpaRepository<AccountDO, Long> {
}
