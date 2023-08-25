package com.example.demopostman.Repository;

import com.example.demopostman.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account,Integer> {
}
