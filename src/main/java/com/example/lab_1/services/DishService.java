package com.example.lab_1.services;

import com.example.lab_1.models.Dish;
import com.example.lab_1.repositories.DishRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author : Denys Lunhu
 * @since : 25.12.2022, Sun
 **/

@Service
@AllArgsConstructor
public class DishService {
    private final DishRepository dishRepository;

    public Dish getOne(String id) {
        Optional<Dish> dish = dishRepository.findById(id);
        return dish.orElse(null);
    }

    public Dish create(Dish dish) {
        return dishRepository.save(dish);
    }

    public Dish update(String id, Dish dish) {
        dish.setId(id);
        return dishRepository.save(dish);
    }

    public Dish delete(String id) {
        Dish dish = this.getOne(id);
        dishRepository.deleteById(id);
        return dish;
    }

    public List<Dish> getAll() {
        return dishRepository.findAll();
    }
}
