package com.example.natvkg.entities.dtos;

import com.example.natvkg.entities.OrderDate;
import jakarta.persistence.GeneratedValue;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDto {
    @GeneratedValue
    Long id;
    String clientEmail;
    String clientFIO;
    String clientPhone;
    String text;
    double totalPrice;
    String status;
    List<ChannelDtoForOrder> channels;

}
