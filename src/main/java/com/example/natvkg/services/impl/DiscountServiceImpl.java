package com.example.natvkg.services.impl;
import com.example.natvkg.entities.Discount;
import com.example.natvkg.entities.dtos.DiscountDto;
import com.example.natvkg.entities.dtos.DiscountDtoForSaving;
import com.example.natvkg.repositories.ChannelRepo;
import com.example.natvkg.repositories.DiscountRepo;
import com.example.natvkg.mappers.DiscountMapper;
import com.example.natvkg.services.DiscountService;
import com.example.natvkg.utils.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
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
    @Override
    public DiscountDtoForSaving save(DiscountDtoForSaving discountDto) {
        Discount discount = DiscountMapper.INSTANCE.toDiscountFromSaving(discountDto);
        discount.setStart_date(new Date());
        discount.setEnd_date(DateUtil.getInstance().getEndDate());
        return DiscountMapper.INSTANCE.toDiscountDtoFromSaving(discountRepo.save(discount));
    }
    @Override
    public List<DiscountDtoForSaving> list() {
        return DiscountMapper.INSTANCE.toDiscountDtoFromSavings(discountRepo.findAll());
    }

    @Override
    public Object update(DiscountDtoForSaving discountDtoForSaving) {
        Optional<Discount> discount1 = discountRepo.findById(discountDtoForSaving.getDiscountId());

        if(discount1.isPresent()){
            Discount trueDiscount = discount1.get();
            trueDiscount = DiscountMapper.INSTANCE.toDiscountFromSaving(discountDtoForSaving);
            trueDiscount.setStart_date(new Date());
            trueDiscount.setEnd_date(DateUtil.getInstance().getEndDate());
            Long id = 1L;
            Long channelId = discountDtoForSaving.getChannel_id();
            trueDiscount.setChannel(channelRepo.findById(channelId != null ? channelId : id).get());
            discountRepo.save(trueDiscount);

            return ResponseEntity.ok(trueDiscount).getBody();
        }
        return ResponseEntity.ok("No discount with such id").getBody();
    }
}