package com.example.lab_1.services;

import com.example.lab_1.models.Order;
import com.example.lab_1.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author : Denys Lunhu
 * @since : 26.12.2022, Mon
 **/

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Order getOne(String id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.orElse(null);
    }

    public Order create(Order order) {
        return orderRepository.save(order);
    }

    public Order update(String id, Order order) {
        order.setId(id);
        return orderRepository.save(order);
    }

    public Order delete(String id) {
        Order order = this.getOne(id);
        orderRepository.deleteById(id);
        return order;
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
