package com.example.natvkg.controllers;

import com.example.natvkg.entities.dtos.CalculateDto;
import com.example.natvkg.entities.dtos.ChannelDto;
import com.example.natvkg.services.ChannelService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/channel")
@Data
@RequiredArgsConstructor
public class ChannelController {
    private final ChannelService channelService;
    @PostMapping("/save")
    public ResponseEntity<ChannelDto> create(@RequestBody ChannelDto channelDto){
        return ResponseEntity.ok(channelService.save(channelDto));
    }
    @GetMapping("/list")
    public ResponseEntity<List<ChannelDto>> toList(){
        return ResponseEntity.ok(channelService.list());
    }
    @GetMapping("/calculate")
    public ResponseEntity<?> calculate(@RequestBody CalculateDto orderDto){
        return channelService.calculate(orderDto);
    }
    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody ChannelDto channelDto){
        return channelService.update(channelDto);
    }
}
