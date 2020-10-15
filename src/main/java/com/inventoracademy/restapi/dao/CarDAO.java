package com.inventoracademy.restapi.dao;

import com.inventoracademy.restapi.model.Car;

import java.util.List;

public interface CarDAO {
    void create (Car car);
    Car read(long id);
    void update(long id, Car newCar);
    void delete(long id);
    List<Car> readlist();
}
