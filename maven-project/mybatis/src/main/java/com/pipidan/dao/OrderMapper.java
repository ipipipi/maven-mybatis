package com.pipidan.dao;

import com.pipidan.test.Order;

import java.util.List;  

public interface OrderMapper {
    public void addOrders(List<Order> orders);
    public List<Order> findAll();

}
