package com.example.lab_1.controllers;

import com.example.lab_1.models.Dish;
import com.example.lab_1.services.DishService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Denys Lunhu
 * @since : 25.12.2022, Sun
 **/

@RestController
@RequestMapping("/api/dish")
@AllArgsConstructor
public class DishController {
    private final DishService dishService;

    @GetMapping("/{id}")
    public Dish getDish(@PathVariable String id) {
        return dishService.getOne(id);
    }

    @PostMapping
    @Secured("ROLE_MANAGER")
    public Dish createDish(@RequestBody Dish dish) {
        return dishService.create(dish);
    }

    @PutMapping("/{id}")
    @Secured("ROLE_MANAGER")
    public Dish updateDish(@PathVariable String id, @RequestBody Dish dish) {
        return dishService.update(id, dish);
    }

    @DeleteMapping("/{id}")
    @Secured("ROLE_MANAGER")
    public Dish deleteDish(@PathVariable String id) {
        return dishService.delete(id);
    }

    @GetMapping()
    public List<Dish> getAllDishes() {
        return dishService.getAll();
    }
}
