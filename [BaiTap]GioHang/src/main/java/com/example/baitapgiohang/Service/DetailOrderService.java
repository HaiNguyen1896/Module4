package com.example.baitapgiohang.Service;

import com.example.baitapgiohang.Model.DetailOrder;
import com.example.baitapgiohang.Repository.IDetailOrderRepo;
import com.example.baitapgiohang.Service.IService.IDetailOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DetailOrderService implements IDetailOrderService {
    @Autowired
    IDetailOrderRepo iDetailOrderRepo;
    @Override
    public void add(DetailOrder detailOrder) {
        iDetailOrderRepo.save(detailOrder);
    }

    @Override
    public List<DetailOrder> findAll() {
        return (List<DetailOrder>) iDetailOrderRepo.findAll();
    }
}
