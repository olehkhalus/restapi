package com.inventoracademy.restapi.model;

public class UpdateCarResponse {
    private String newBrand;
    private String newType;
    private int newYear;

    public String getNewBrand() {
        return newBrand;
    }

    public void setNewBrand(String newBrand) {
        this.newBrand = newBrand;
    }

    public String getNewType() {
        return newType;
    }

    public void setNewType(String newType) {
        this.newType = newType;
    }

    public int getNewYear() {
        return newYear;
    }

    public void setNewYear(int newYear) {
        this.newYear = newYear;
    }
}
