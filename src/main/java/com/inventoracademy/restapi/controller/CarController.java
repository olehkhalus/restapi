package com.inventoracademy.restapi.controller;

import com.inventoracademy.restapi.model.Car;
import com.inventoracademy.restapi.model.CarResponse;
import com.inventoracademy.restapi.model.UpdateCarResponse;
import com.inventoracademy.restapi.service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/restapi")
public class CarController {


    private CarServiceImpl carService;

    @Autowired
    public CarController(CarServiceImpl carService){
        this.carService = carService;
    }

    @GetMapping("/getcar")
    public ResponseEntity<Car> getCar(
            @RequestParam long id){
        return ResponseEntity.of(Optional.of(
                carService.read(id)));
    }

    @GetMapping("/getcar/list")
    public ResponseEntity getCarList(){
        return ResponseEntity.of(Optional.of(
                carService.readlist()
        ));
    }

    @PostMapping("/createcar")
    public ResponseEntity createCar(
            @RequestBody CarResponse car){
        Car newCar = new Car(car.getId(),car.getBrand(),car.getType(),car.getYear());
        carService.create(newCar);
        return ResponseEntity.created(URI.create("/car/" + car.getBrand())).build();
    }

    @PutMapping("/updatecar")
    public ResponseEntity updateCar(
            @RequestParam long id,
            @RequestBody UpdateCarResponse updateCar){
        Car newCar = new Car(id,updateCar.getNewBrand(),updateCar.getNewType(),updateCar.getNewYear());
        carService.update(id,newCar);
        return ResponseEntity.ok("");
    }

    @DeleteMapping("/deletecar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(
            @RequestParam long id){
        carService.delete(id);
    }
}
