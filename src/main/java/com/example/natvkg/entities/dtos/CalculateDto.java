package com.example.natvkg.entities.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CalculateDto {
    String text;
    int daysCount;
    @JsonProperty("channelId")
    Long channel_id;
    double price;
    double priceWithDiscount;
}
