package com.example.demopostman.Repository;

import com.example.demopostman.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAccountRepository extends JpaRepository<Account,Integer> {
    @Query(
    value="select a from Account a where a.username like concat('%',:name,'%')")
    List<Account> findAccountNameByKeyword(@Param("name")String keyword);
    @Query(value = "select a from Account a where a.username like concat('%',:username,'%') and a.password like concat('%',:password,'%') ")
    Account findAccount(@Param("username") String username,@Param("password") String password);
}
