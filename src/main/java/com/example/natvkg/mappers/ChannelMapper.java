package com.example.natvkg.mappers;

import com.example.natvkg.entities.Channel;
import com.example.natvkg.entities.dtos.ChannelDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChannelMapper {
    Channel toChannel(ChannelDto channelDto);
    ChannelDto toChannelDto(Channel channel);
}
