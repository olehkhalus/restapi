package com.inventoracademy.restapi.service;

import com.inventoracademy.restapi.dao.CarDAOImpl;
import com.inventoracademy.restapi.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarDAOImpl carDAOImpl;

    @Override
    public void create(Car car) {
        carDAOImpl.create(car);
    }

    @Override
    public Car read(long id) {
        return carDAOImpl.read(id);
    }

    @Override
    public void update(long id, Car newCar) {
        carDAOImpl.update(id,newCar);
    }

    @Override
    public void delete(long id) {
        carDAOImpl.delete(id);
    }

    @Override
    public List<Car> readlist() {
        return carDAOImpl.readlist();
    }
}
