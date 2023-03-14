package com.example.natvkg.services;

import com.example.natvkg.entities.Order;
import com.example.natvkg.entities.dtos.OrderDto;

import java.util.List;

public interface OrderService {

   OrderDto save(OrderDto orderDto);

    List<Order> list();


}
