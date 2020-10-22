package com.inventoracademy.restapi.controller;

import com.inventoracademy.restapi.model.Car;
import com.inventoracademy.restapi.model.CarRequest;
import com.inventoracademy.restapi.model.UpdateCarRequest;
import com.inventoracademy.restapi.service.CarServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/restapi")
public class CarController {


    private CarServiceImpl carService;


    public CarController(CarServiceImpl carService){
        this.carService = carService;
    }

    @GetMapping("/car")
    public ResponseEntity<Car> getCar(
            @RequestParam long id){
        return ResponseEntity.of(Optional.of(
                carService.read(id)));
    }

    @GetMapping("/cars")
    public ResponseEntity getCarList(){
        return ResponseEntity.of(Optional.of(
                carService.readlist()
        ));
    }

    @PostMapping("/cars")
    public ResponseEntity createCar(
            @RequestBody CarRequest car){
        Car newCar = new Car(car.getId(),car.getBrand(),car.getType(),car.getYear());
        carService.create(newCar);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCar);
    }

    @PutMapping("/cars")
    public ResponseEntity updateCar(
            @RequestBody UpdateCarRequest updateCar){
        return ResponseEntity.ok(carService.update(updateCar));
    }

    @DeleteMapping("/cars")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(
            @RequestParam long id){
        carService.delete(id);
    }
}
