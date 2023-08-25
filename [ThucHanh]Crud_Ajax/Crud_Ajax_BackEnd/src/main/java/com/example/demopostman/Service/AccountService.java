package com.example.demopostman.Service;
import com.example.demopostman.Model.Account;
import com.example.demopostman.Repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    IAccountRepository iAccountRepository;

    public List<Account> getAll(){
        return iAccountRepository.findAll();
    }

    public Account save(Account account){
        return iAccountRepository.save(account);
    }
    public void delete(int id){
        iAccountRepository.deleteById(id);
    }
    public Account findAccountByID(int id){
        return iAccountRepository.findById(id).get();
    }
}
