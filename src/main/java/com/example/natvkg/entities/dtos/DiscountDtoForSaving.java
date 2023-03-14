package com.example.natvkg.entities.dtos;

import com.example.natvkg.entities.Channel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DiscountDtoForSaving {
    @Id
    @GeneratedValue
    Long discountId;
    int discount;
    @JsonProperty("from_days_count")
    int discount_days;
    Long channel_id;
}
