package com.example.natvkg.mappers;

import com.example.natvkg.entities.Channel;
import com.example.natvkg.entities.Order;
import com.example.natvkg.entities.dtos.ChannelDtoForOrder;
import com.example.natvkg.entities.dtos.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    @Mapping(target = "text",source = "textAd.text")
    OrderDto orderToOrderDto(Order order);
    @Mapping(target = "textAd.text",source = "text")
    @Mapping(target = "textAd.symbol_count",source ="orderDto",qualifiedByName = "calculateSymbolCount")
    Order toOrder(OrderDto orderDto);
    @Named("calculateSymbolCount")
    default Integer calculateSymbolCount(OrderDto orderDto) {
    return orderDto.getText().replaceAll(" ","").length();
}
    @Mapping(target = "channelId",source = "channel.id")
    ChannelDtoForOrder toChannelDtoForOrder(Channel channel);

    ArrayList<ChannelDtoForOrder> channelListToChannelDtoForOrderList(List<Channel> channels);
}
