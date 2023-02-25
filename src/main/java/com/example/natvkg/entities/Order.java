package com.example.natvkg.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tb_orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Date created_date;
    String client_email;
    String client_fio;
    String client_phone;
    String order_status;
    @ManyToOne
    @JoinColumn(name = "channel_id")
    Channel channel;
    @ManyToOne
    @JoinColumn(name = "text_ad_id")
    TextAd textAd;
    @ManyToOne
    @JoinColumn(name = "banner_ad_id")
    BannerAd bannerAd;
    double order_sum;



}
