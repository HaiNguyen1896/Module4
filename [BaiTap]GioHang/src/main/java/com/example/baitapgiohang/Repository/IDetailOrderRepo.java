package com.example.baitapgiohang.Repository;

import com.example.baitapgiohang.Model.DetailOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IDetailOrderRepo extends CrudRepository<DetailOrder,Long> {
}
