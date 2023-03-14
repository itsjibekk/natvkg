package com.example.natvkg.services;

import com.example.natvkg.entities.dtos.CalculateDto;
import com.example.natvkg.entities.dtos.ChannelDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ChannelService {
    ChannelDto save(ChannelDto channelDto);

    List<ChannelDto> list();

     ResponseEntity<?> calculate(CalculateDto orderDto);

    ResponseEntity<?> update(ChannelDto channelDto);
}
