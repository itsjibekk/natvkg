package com.example.natvkg.controllers;

import com.example.natvkg.entities.Discount;
import com.example.natvkg.entities.dtos.ChannelDto;
import com.example.natvkg.entities.dtos.DiscountDto;
import com.example.natvkg.entities.dtos.DiscountDtoForSaving;
import com.example.natvkg.services.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/discount")
public class DiscountController {

    private final DiscountService discountService;

    @PostMapping("/save")
    public ResponseEntity<?> create(@RequestBody DiscountDtoForSaving discountDto){
        return ResponseEntity.ok(discountService.save(discountDto));
    }

    @GetMapping("/read")
    public ResponseEntity<?> read(){
        return ResponseEntity.ok(discountService.list());
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody DiscountDtoForSaving discount){
        return ResponseEntity.ok(discountService.update(discount));
    }
}
