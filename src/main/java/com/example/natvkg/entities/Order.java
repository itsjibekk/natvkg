package com.example.natvkg.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tb_orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Date created_date;
    String clientEmail;
    String clientFIO;
    String clientPhone;
    String status;
    @ManyToMany
    @JoinTable(
            name = "order_channel",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "channel_id"))
    private Set<Channel> channels = new HashSet<>();
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "text_ad_id")
    TextAd textAd;
    double totalPrice;
    @PrePersist
    public void prePersist() {
        status = "CREATED";
        created_date = new Date();
    }
}
