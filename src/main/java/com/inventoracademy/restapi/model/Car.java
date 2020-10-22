package com.inventoracademy.restapi.model;

import java.util.Objects;

public class Car {
    private long id;
    private String brand;
    private String type;
    private int year;

    public Car(){

    }
    public Car(long id, String brand, String type, int year) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id &&
                year == car.year &&
                Objects.equals(brand, car.brand) &&
                Objects.equals(type, car.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, type, year);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
