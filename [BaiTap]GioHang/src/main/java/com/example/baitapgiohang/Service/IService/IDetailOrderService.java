package com.example.baitapgiohang.Service.IService;

import com.example.baitapgiohang.Model.DetailOrder;

import java.util.List;

public interface IDetailOrderService {
    public void add(DetailOrder detailOrder);
    List<DetailOrder> findAll();
}
