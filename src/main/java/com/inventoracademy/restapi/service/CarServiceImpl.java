package com.inventoracademy.restapi.service;

import com.inventoracademy.restapi.dao.CarDAOImpl;
import com.inventoracademy.restapi.model.Car;
import com.inventoracademy.restapi.model.UpdateCarRequest;
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
    public Car read(Long id) {
        return carDAOImpl.read(id);
    }

    @Override
    public Car update(UpdateCarRequest updateCar) {
        return carDAOImpl.update(updateCar);
    }

    @Override
    public void delete(Long id) {
        carDAOImpl.delete(id);
    }

    @Override
    public List<Car> readlist() {
        return carDAOImpl.readlist();
    }
}
