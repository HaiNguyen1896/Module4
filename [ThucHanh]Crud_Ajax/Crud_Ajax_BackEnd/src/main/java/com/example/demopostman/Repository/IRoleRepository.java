package com.example.demopostman.Repository;

import com.example.demopostman.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role,Integer> {
}
