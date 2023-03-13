package com.example.natvkg.repositories;

import com.example.natvkg.entities.OrderDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface OrderDateRepo extends JpaRepository<OrderDate,Long> {
    @Query("select od.date, od.id from OrderDate od\n" +
            "where od.order.id = :order_id and od.channel.id = :channel_id")
    List<Date> getDatesByChannelAndOrder(Long channel_id, Long order_id);
}
