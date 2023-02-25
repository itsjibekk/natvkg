package com.example.natvkg.entities.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChannelDto {
    Long channelId;
    @JsonProperty("name")
    String channelName;
    @JsonProperty("price_per_letter")
    int price;
    String logo;
    @JsonProperty("discounts")
    List<DiscountDto> discountList;
    boolean active;

}
