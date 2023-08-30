package com.doza.cloud.DozaCloud.controllers;


import com.doza.cloud.DozaCloud.models.Car;
import com.doza.cloud.DozaCloud.models.CarOrder;
import com.doza.cloud.DozaCloud.repository.CarRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/tacos",
        produces = "application/json")
@CrossOrigin(origins = "http://dozacloud:8080")
public class CarController {

    private CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping(params = "recent")
    public Iterable<Car> recentCars() {
        PageRequest page = PageRequest.of(
                0, 12, Sort.by("createdAt").descending());
        return carRepository.findAll(page).getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> carById(@PathVariable("id") Long id) {
        Optional<Car> optCar = carRepository.findById(id);
        if (optCar.isPresent()) {
            return new ResponseEntity<>(optCar.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Car postCar(@RequestBody Car car) {
        return carRepository.save(car);
    }
}
