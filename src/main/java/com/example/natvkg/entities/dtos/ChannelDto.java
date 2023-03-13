package com.example.natvkg.entities.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.GeneratedValue;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChannelDto {
    @GeneratedValue
    Long id;
    @JsonProperty("name")
    String channel_name;
    @JsonProperty("price_per_letter")
    int price_per_symbol;
    String logo_path;
    @JsonProperty("discounts")
    List<DiscountDto> discountList;
}
