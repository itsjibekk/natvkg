package com.example.natvkg.mappers;

import com.example.natvkg.entities.Discount;
import com.example.natvkg.entities.dtos.DiscountDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiscountMapper {
    Discount toDiscount(DiscountDto discountDto);
    DiscountDto toDiscountDto(Discount discount);
}
