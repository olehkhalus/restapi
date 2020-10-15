package com.inventoracademy.restapi.controller;

import com.inventoracademy.restapi.model.Car;
import com.inventoracademy.restapi.model.CarResponse;
import com.inventoracademy.restapi.model.UpdateCarResponse;
import com.inventoracademy.restapi.service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/restapi")
public class CarController {


    private CarServiceImpl carService;

    @Autowired
    public CarController(CarServiceImpl carService){
        this.carService = carService;
    }

    @CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
    @GetMapping("/getcar")
    public ResponseEntity getCar(
            @RequestParam long id){
        return ResponseEntity.of(Optional.of(
                carService.read(id)));
    }

    @CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
    @GetMapping("/getcar/list")
    public ResponseEntity getCarList(){
        return ResponseEntity.of(Optional.of(
                carService.readlist()
        ));
    }
    @CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
    @PostMapping("/createcar")
    public ResponseEntity createCar(
            @RequestBody CarResponse car){
        Car newCar = new Car(car.getId(),car.getBrand(),car.getType(),car.getYear());
        carService.create(newCar);
        return ResponseEntity.ok("Car was created!");
    }

    @CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
    @PutMapping("/updatecar")
    public ResponseEntity updateCar(
            @RequestParam long id,
            @RequestBody UpdateCarResponse updateCar){
        Car newCar = new Car(id,updateCar.getNewBrand(),updateCar.getNewType(),updateCar.getNewYear());
        carService.update(id,newCar);
        return ResponseEntity.ok("Car was update!");
    }
    @CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
    @DeleteMapping("/deletecar")
    public ResponseEntity deleteCar(
            @RequestParam long id){
        carService.delete(id);
        return ResponseEntity.ok("Car was deleted");
    }
}
