package com.example.natvkg.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    int price_per_symbol;

    @JsonFormat(pattern = "dd.MM.yyyy")
    Date start_date;
    @JsonFormat(pattern = "dd.MM.yyyy")
    Date end_date;
    @ManyToOne
    @JoinColumn(name = "channel_id")
    Channel channel;
}
