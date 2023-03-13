package com.example.natvkg.entities.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChannelDtoForOrder {
    Long channelId;
    @JsonFormat(pattern = "dd.MM.yyyy")
    List<Date> days;
    double price;
    double priceWithDiscount;
    public void setDays(List<Date> days) {
        this.days = days;
    }

}
