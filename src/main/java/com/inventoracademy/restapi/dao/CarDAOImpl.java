package com.inventoracademy.restapi.dao;

import com.inventoracademy.restapi.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDAOImpl implements CarDAO {

    List<Car> carList = new ArrayList<>();


    @Override
    public void create(Car car) {
        Car model = new Car(car.getId(), car.getBrand(), car.getType(), car.getYear());
        carList.add(model);
    }

    @Override
    public Car read(long id) {
        for (Car car : carList) {
            if (car.getId() == id)
                return car;
        }
        return null;
    }

    @Override
    public void update(long id, Car newCar) {
        for (Car car : carList) {
            if (car.getId() == id) {
                car.setBrand(newCar.getBrand());
                car.setType(newCar.getType());
                car.setYear(newCar.getYear());
            }
        }
    }

    @Override
    public void delete(long id) {
        for (Car car : carList) {
            if (car.getId() == id) {
                carList.remove(car);
            }
        }
    }

    @Override
    public List<Car> readlist() {
        return carList;
    }
}

