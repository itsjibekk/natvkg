package com.example.natvkg.services.impl;

import com.example.natvkg.entities.Channel;
import com.example.natvkg.entities.Order;
import com.example.natvkg.entities.OrderDate;
import com.example.natvkg.repositories.ChannelRepo;
import com.example.natvkg.repositories.OrderDateRepo;
import com.example.natvkg.repositories.OrderRepo;
import com.example.natvkg.services.OrderDateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDateServiceImpl implements OrderDateService {
    private final OrderDateRepo orderDateRepo;
    private final OrderRepo orderRepo;
    @Override
    public void saveDates(List<List<Date>> dates, Order order) {
        OrderDate orderDate;
        for (List<Date> object : dates) {
            int i = 0;
            for (Date date : object) {
                orderDate = new OrderDate();
                orderDate.setDate(date);

                if (order.getId() == null) {
                    order.setId(2L);
                }
                Order existingOrder = orderRepo.findById(order.getId())
                        .get();
                orderDate.setOrder(existingOrder);
                Channel firstElement = order.getChannels().stream().skip(i++).findFirst().orElse(null);
                if (firstElement != null) {
                    orderDate.setChannel(firstElement);
                }
                orderDateRepo.save(orderDate);
            }
        }
    }


}
