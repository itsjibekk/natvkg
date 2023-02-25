package com.example.natvkg.entities.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DiscountDto {
    Long discountId;
    @JsonProperty("from_days_count")
    int days;
    int discount;


}
