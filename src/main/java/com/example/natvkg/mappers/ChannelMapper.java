package com.example.natvkg.mappers;

import com.example.natvkg.entities.Channel;
import com.example.natvkg.entities.dtos.ChannelDto;
import com.example.natvkg.entities.dtos.ChannelDtoForOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Date;
import java.util.List;
@Mapper(componentModel = "spring")

public interface ChannelMapper {
    ChannelMapper INSTANCE = Mappers.getMapper(ChannelMapper.class);

    Channel toChannel(ChannelDto channelDto);

    @Mapping(target = "active",source = "active")
    ChannelDto toChannelDto(Channel channel);

    List<ChannelDto> toChannelDtos(List<Channel> channelList);

    ChannelDtoForOrder toChannelDtoFrom(Channel channel);

}
