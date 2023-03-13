package com.example.natvkg.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tb_discounts")
public class Discount {
    @Id
    @GeneratedValue
    Long discountId;
    int discount;
    @JsonFormat(pattern = "dd.MM.yyyy")
    Date start_date;
    @JsonFormat(pattern = "dd.MM.yyyy")
    Date end_date;
    @JsonProperty("from_days_count")
    int discount_days;
    @ManyToOne
    @JoinColumn(name = "channel_id")
    Channel channel;

}
