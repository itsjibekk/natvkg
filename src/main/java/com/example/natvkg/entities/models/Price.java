package com.example.natvkg.entities.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Price {
    @Id
    Long id;
    double price_per_symbol;
    double banner_price;
    Date start_date;
    Date end_date;
    @ManyToOne
    Channel channel;
}
