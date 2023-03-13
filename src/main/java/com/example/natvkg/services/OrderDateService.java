package com.example.natvkg.services;

import com.example.natvkg.entities.Order;

import java.util.Date;
import java.util.List;

public interface OrderDateService {
   void saveDates(List<List<Date>> dates, Order order);
}
