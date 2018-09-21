package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class CarModel {

    private List<Car> carList = new ArrayList<Car>();

    private String name;

    private List<Integer> dataValues = new ArrayList<Integer>();

    public List<Car> getCarList() {
        return carList;
    }

    public String getName() {
        return name;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getDataValues() {
        return dataValues;
    }

    public void setDataValues(List<Integer> dataValues) {
        this.dataValues = dataValues;
    }
}
