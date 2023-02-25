package com.example.natvkg.entities.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tb_order_dates")
public class OrderDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Date date;
    @ManyToOne
    @JoinColumn(name = "order_id")
    Order order;

}
