package com.example.natvkg.services.impl;
import com.example.natvkg.entities.Discount;
import com.example.natvkg.entities.dtos.DiscountDto;
import com.example.natvkg.repositories.ChannelRepo;
import com.example.natvkg.repositories.DiscountRepo;
import com.example.natvkg.mappers.DiscountMapper;
import com.example.natvkg.services.DiscountService;
import com.example.natvkg.utils.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {
    private final DiscountRepo discountRepo;
    private final ChannelRepo channelRepo;
    @Override
    public DiscountDto saveDiscount(DiscountDto discountDto,Long id) {
        Discount discount = DiscountMapper.INSTANCE.toDiscount(discountDto);
        int defaultId = 1;
        discount.setChannel(channelRepo.getById(id != null ? id : defaultId));
        discount.setStart_date(new Date());
        discount.setEnd_date(DateUtil.getInstance().getEndDate());
        discountRepo.save(discount);
        return DiscountMapper.INSTANCE.toDiscountDto(discount);
    }
    @Override
    public List<DiscountDto> saveAllDiscounts(List<DiscountDto> discountList,Long id) {
        return discountList.stream().map(x -> saveDiscount(x, id ) ).collect(Collectors.toList());
    }
}