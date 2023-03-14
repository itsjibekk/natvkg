package com.example.natvkg.services.impl;

import com.example.natvkg.entities.Channel;
import com.example.natvkg.entities.Order;
import com.example.natvkg.entities.TextAd;
import com.example.natvkg.entities.dtos.ChannelDtoForOrder;
import com.example.natvkg.entities.dtos.OrderDto;
import com.example.natvkg.mappers.OrderMapper;
import com.example.natvkg.repositories.*;
import com.example.natvkg.services.OrderDateService;
import com.example.natvkg.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    private final OrderDateRepo orderDateRepo;
    private final ChannelRepo channelRepo;
    private final OrderDateService orderDateService;
    private final PriceRepo priceRepo;
    private final DiscountRepo discountRepo;
    private final TextAdRepo textAdRepo;
    @Override
    public OrderDto save(OrderDto orderDto) {
         List<Long> channelIds = orderDto.getChannels().stream()
                .map(x -> x.getChannelId())
                .collect(Collectors.toList());
         List<Channel> selectedChannels = channelRepo.findAllById(channelIds);

         Order order = OrderMapper.INSTANCE.toOrder(orderDto);
         Set<Channel> channelList = new HashSet<>( selectedChannels);
         order.setChannels(channelList);
         orderRepo.save(order);

         OrderDto orderDto1 = OrderMapper.INSTANCE.orderToOrderDto(order);

         List<List<Date>> dates = orderDto.getChannels().stream().map(x -> x.getDays()).collect(Collectors.toList());
         orderDateService.saveDates(dates,order);

         orderDto1.setChannels(getChannelsForOrder(order,orderDto));

         double totalPrice = orderDto1.getChannels().stream().mapToDouble(x-> x.getPriceWithDiscount()).sum();
         orderDto1.setTotalPrice(totalPrice);
         order.setTotalPrice(totalPrice);
         orderRepo.save(order);
         return orderDto1;
    }

    @Override
    public List<Order> list() {
        return orderRepo.findAll();
    }



    public List<ChannelDtoForOrder> getChannelsForOrder(Order order,OrderDto orderDto) {
        List<ChannelDtoForOrder> channelDtoList = new ArrayList<>();
        for (Channel channel : order.getChannels()) {
            ChannelDtoForOrder channelDto = new ChannelDtoForOrder();
            channelDto.setChannelId(channel.getId());
            List<Date> dates = orderDateRepo.getDatesByChannelAndOrder(channel.getId(), order.getId());
            channelDto.setDays(dates);
            Integer price_per_symbol =  priceRepo.findPriceByChannel_id(channel.getId());
            price_per_symbol = price_per_symbol != null ? price_per_symbol : 1;
            double text_count = order.getTextAd().getText().length();
            double price = price_per_symbol * text_count;
            channelDto.setPrice(price);
           int daysCount = channelDto.getDays().size();

            Integer discount = (Integer) discountRepo.findDiscountByChannelId(daysCount,channel.getId());
            int discountNotNull = (discount != null) ? discount : 0;
            if(discountNotNull == 0){
                channelDto.setPriceWithDiscount(price);
            }else{
                double priceWithDiscount = price - ( (price * discount)/100 );
                channelDto.setPriceWithDiscount(priceWithDiscount);
            }

            channelDtoList.add(channelDto);
        }
        return channelDtoList;
    }
}


