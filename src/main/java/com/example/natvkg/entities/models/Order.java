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
public class Order {
    @Id
    Long id;
    Date created_date;
    String client_email;
    String client_fio;
    String client_phone;
    String order_status;
    @ManyToOne
    Channel channel;
    @ManyToOne
    TextAd textAd;
    @ManyToOne
    BannerAd bannerAd;
    double order_sum;



}
