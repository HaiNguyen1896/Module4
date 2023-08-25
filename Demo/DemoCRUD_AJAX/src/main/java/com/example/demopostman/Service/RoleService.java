package com.example.demopostman.Service;

import com.example.demopostman.Model.Role;
import com.example.demopostman.Repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    IRoleRepository iRoleRepository;
    public List<Role> getAll(){
       return iRoleRepository.findAll();
    }
    public Role findRoleByID(int id){
        return iRoleRepository.findById(id).get();
    }
}
