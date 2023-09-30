package com.shop.controller;

import com.shop.dto.OrderDto;
import com.shop.dto.OrderResponse;

import com.shop.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService service;


    @PostMapping
    public Long addNewProduct(@RequestBody OrderDto order){
        log.info("Run method add new product");
        return service.addOrder(order);
    }

    @GetMapping("/{id}")
    public OrderResponse getOrderById(@PathVariable Long id){
        log.info("Run method get order by id");
        return service.getOrderById(id);
    }



}
