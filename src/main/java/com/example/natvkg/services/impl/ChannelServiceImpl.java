package com.example.natvkg.services.impl;

import com.example.natvkg.entities.Channel;
import com.example.natvkg.entities.dtos.CalculateDto;
import com.example.natvkg.entities.dtos.ChannelDto;
import com.example.natvkg.mappers.ChannelMapper;
import com.example.natvkg.mappers.DiscountMapper;
import com.example.natvkg.repositories.ChannelRepo;
import com.example.natvkg.repositories.DiscountRepo;
import com.example.natvkg.repositories.OrderDateRepo;
import com.example.natvkg.repositories.PriceRepo;
import com.example.natvkg.services.ChannelService;
import com.example.natvkg.services.DiscountService;
import com.example.natvkg.services.PriceService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
@Data
public class ChannelServiceImpl implements ChannelService {
    private final ChannelRepo channelRepo;
    private final DiscountService discountService;
    private final PriceService priceService;
    private final DiscountRepo discountRepo;
    private final PriceRepo priceRepo;
    private final OrderDateRepo orderDateRepo;
    @Override
    public ChannelDto save(ChannelDto channelDto) {
        Channel channel = channelRepo.save(ChannelMapper.INSTANCE.toChannel(channelDto));
        channel.setCreated_date(new Date());
        ChannelDto channelDto1 = ChannelMapper.INSTANCE.toChannelDto(channel);
        channelDto1.setPrice_per_symbol(priceService.save(channelDto.getPrice_per_symbol(), channel.getId()));
        channelDto1.setDiscountList(discountService.saveAllDiscounts(channelDto.getDiscountList(), channelDto1.getId()));
        return channelDto1;
    }
    @Override
    public List<ChannelDto> list() {
        List<ChannelDto> list = ChannelMapper.INSTANCE.toChannelDtos(channelRepo.getAll());
        list = list.stream().map(x -> {
            x.setDiscountList(DiscountMapper.INSTANCE.toDiscountDtos(discountRepo.findAllByChannel_Id(x.getId())));
            x.setPrice_per_symbol(priceRepo.findPriceByChannel_id(x.getId()));
            return x;
        }).collect(Collectors.toList());
        return list;
    }
    @Override
    public ResponseEntity<?> calculate(CalculateDto orderDto) {
        double price;
        if (priceRepo.findPriceByChannel_id(orderDto.getChannel_id()) != null) {
            int pricePerLetter = priceRepo.findPriceByChannel_id(orderDto.getChannel_id());
            String stringWithoutSpaces = orderDto.getText().replaceAll("\\s+", "");
            if (stringWithoutSpaces.length() < 20)
                return ResponseEntity.ok("Enter at least 20 characters in announcement text(not counting spaces)");
            price = pricePerLetter * stringWithoutSpaces.length() * orderDto.getDaysCount();
            orderDto.setPrice(price);
            Integer discount = (Integer) priceRepo.findByDaysAndChannelId(orderDto.getDaysCount(), orderDto.getChannel_id());
            int discountNotNull = (discount != null) ? discount : 0;
            if (discountNotNull == 0) orderDto.setPriceWithDiscount(price);
            else {
                double priceWithDiscount = price - (price * discount) / 100;
                orderDto.setPriceWithDiscount(priceWithDiscount);
            }
        } else {
            return ResponseEntity.ok("No such channel");
        }
        return ResponseEntity.ok(orderDto);
    }
    @Override
    public ResponseEntity<?> update(ChannelDto channelDto) {
       Optional<Channel> channel1 = channelRepo.findById(channelDto.getId());
        if (channel1.isPresent()) {
            Channel channel = channel1.get();
            channel = channelRepo.save(ChannelMapper.INSTANCE.toChannel(channelDto));
            channel.setCreated_date(new Date());
            ChannelDto channelDto1 = ChannelMapper.INSTANCE.toChannelDto(channel);
            channelDto1.setPrice_per_symbol(priceService.save(channelDto.getPrice_per_symbol(), channel.getId()));
            channelDto1.setDiscountList(discountService.saveAllDiscounts(channelDto.getDiscountList(), channelDto1.getId()));
            return ResponseEntity.ok(channelDto1);
        }

        return ResponseEntity.ok("No such channel");
    }
}

