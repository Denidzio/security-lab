package com.example.lab_1.controllers;

import com.example.lab_1.models.Order;
import com.example.lab_1.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Denys Lunhu
 * @since : 26.12.2022, Mon
 **/

@RestController
@RequestMapping("/api/order")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/{id}")
    @Secured("ROLE_MANAGER")
    public Order getOrder(@PathVariable String id) {
        return orderService.getOne(id);
    }

    @PostMapping
    @Secured("ROLE_CLIENT")
    public Order createOrder(@RequestBody Order order) {
        return orderService.create(order);
    }

    @PutMapping("/{id}")
    @Secured("ROLE_MANAGER")
    public Order updateOrder(@PathVariable String id, @RequestBody Order order) {
        return orderService.update(id, order);
    }

    @DeleteMapping("/{id}")
    @Secured("ROLE_MANAGER")
    public Order deleteOrder(@PathVariable String id) {
        return orderService.delete(id);
    }

    @GetMapping()
    @Secured("ROLE_MANAGER")
    public List<Order> getAllOrders() {
        return orderService.getAll();
    }
}
