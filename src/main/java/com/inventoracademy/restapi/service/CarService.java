package com.inventoracademy.restapi.service;

import com.inventoracademy.restapi.model.Car;

import java.util.List;

public interface CarService {
    void create (Car car);
    Car read(long id);
    void update(long id, Car newCar);
    void delete(long id);
    List<Car> readlist();
}
