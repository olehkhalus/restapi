package com.inventoracademy.restapi.service;

import com.inventoracademy.restapi.model.Car;
import com.inventoracademy.restapi.model.UpdateCarRequest;

import java.util.List;

public interface CarService {
    void create (Car car);
    Car read(Long id);
    Car update(UpdateCarRequest updateCar);
    void delete(Long id);
    List<Car> readlist();
}
