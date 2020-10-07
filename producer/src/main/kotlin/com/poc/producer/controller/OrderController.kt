package com.poc.producer.controller

import com.poc.producer.model.Order
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/order")
class OrderController {

    @GetMapping("/{id}")
    fun getOrderStatus(@PathVariable id: Long): ResponseEntity<Order> {
        if(id>10){
           return ResponseEntity.ok().body(Order(false))
        }
        return ResponseEntity.ok().body(Order(true))
    }
}