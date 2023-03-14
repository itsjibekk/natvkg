package com.example.natvkg.mappers;

import com.example.natvkg.entities.Channel;
import com.example.natvkg.entities.Discount;
import com.example.natvkg.entities.dtos.DiscountDto;
import com.example.natvkg.entities.dtos.DiscountDtoForSaving;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(componentModel = "spring")
public interface DiscountMapper {
    DiscountMapper INSTANCE = Mappers.getMapper(DiscountMapper.class);
    @Mapping(target = "discount_days",source = "discount_days")
    @Mapping(target = "discount",source = "discount")
    Discount toDiscount(DiscountDto discountDto);
    @Mapping(target = "discount_days",source = "discount_days")
    @Mapping(target = "discount",source = "discount")
    DiscountDto toDiscountDto(Discount discount);
    List<Discount> toDiscounts(List<DiscountDto> discountList);
    List<DiscountDto> toDiscountDtos(List<Discount> saveAll);
    @Mapping(target = "channel.id", source = "channel_id")
    @Mapping(target = "discount", source = "discount")
    @Mapping(target = "discount_days", source = "discount_days")
    @Mapping(target = "discountId", source = "discountId")
    Discount toDiscountFromSaving(DiscountDtoForSaving discountDtoForSaving);
    @Mapping(target = "channel_id",source = "channel.id")
    @Mapping(target = "discount", source = "discount")
    @Mapping(target = "discount_days", source = "discount_days")
    @Mapping(target = "discountId", source = "discountId")
    DiscountDtoForSaving toDiscountDtoFromSaving(Discount discount);

    List<DiscountDtoForSaving> toDiscountDtoFromSavings(List<Discount> all);
}
