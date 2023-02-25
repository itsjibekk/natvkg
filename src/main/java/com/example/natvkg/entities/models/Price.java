package com.example.natvkg.entities.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tb_prices")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    double price_per_symbol;
    double banner_price;
    Date start_date;
    Date end_date;
    @ManyToOne
    @JoinColumn(name = "channel_id")
    Channel channel;
}
