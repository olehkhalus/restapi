package com.inventoracademy.restapi.dao;

import com.inventoracademy.restapi.model.Car;
import com.inventoracademy.restapi.model.UpdateCarRequest;

import java.util.List;

public interface CarDAO {
    void create (Car car);
    Car read(Long id);
    Car update(UpdateCarRequest updateCar);
    void delete(Long id);
    List<Car> readlist();
}
