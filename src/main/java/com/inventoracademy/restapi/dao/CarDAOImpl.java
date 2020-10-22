package com.inventoracademy.restapi.dao;

import com.inventoracademy.restapi.model.Car;
import com.inventoracademy.restapi.model.UpdateCarRequest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Repository
public class CarDAOImpl implements CarDAO {

    private List<Car> carList = new ArrayList<>();


    @Override
    public void create(Car car) {
        Car model = new Car(car.getId(), car.getBrand(), car.getType(), car.getYear());
        carList.add(model);
    }

    @Override
    public Car read(Long id) {
        for (Car car : carList) {
            if (car.getId() == id)
                return car;
        }
        throw new IllegalArgumentException("Car not found");
    }

    @Override
    public Car update(UpdateCarRequest updateCar) {
        Car updatedCar = new Car();

        Optional<Car> carOptional = carList.stream()
                .filter(car -> car.getId()==(updateCar.getId()))
                .findFirst();
        if(carOptional.isPresent()){

            Car car = carOptional.get();

            updatedCar.setId(updateCar.getId());
            updatedCar.setBrand(updateCar.getBrand());
            updatedCar.setType(updateCar.getType());
            updatedCar.setYear(updateCar.getYear());

            carList.remove(car);
            carList.add(updatedCar);
        }else{
            throw new IllegalArgumentException("Car not found");
        }
        return updatedCar;
    }

    @Override
    public void delete(Long id) {
        carList.removeIf(car -> car.getId() == id);
    }

    @Override
    public List<Car> readlist() {
        return carList;
    }
}

