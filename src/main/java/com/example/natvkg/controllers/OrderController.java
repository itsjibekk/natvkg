package com.example.natvkg.controllers;

import com.example.natvkg.entities.Order;
import com.example.natvkg.entities.dtos.OrderDto;
import com.example.natvkg.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final  OrderService orderService;
    @PostMapping("/save")
    public ResponseEntity<OrderDto> save(@RequestBody OrderDto orderDto){
        return ResponseEntity.ok(orderService.save(orderDto));
    }
    @GetMapping("/read")
    public List<Order> read(){
        return orderService.list();
    }
}
