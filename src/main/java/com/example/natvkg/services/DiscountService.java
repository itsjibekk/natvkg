package com.example.natvkg.services;

import com.example.natvkg.entities.dtos.DiscountDto;
import com.example.natvkg.entities.dtos.DiscountDtoForSaving;

import java.util.List;

public interface DiscountService {
    DiscountDto saveDiscount(DiscountDto discountDto,Long id);

    List<DiscountDto> saveAllDiscounts(List<DiscountDto> discountList,Long id);

    DiscountDtoForSaving save(DiscountDtoForSaving discountDto);

    List<DiscountDtoForSaving> list();

    Object update(DiscountDtoForSaving discount);
}
