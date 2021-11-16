package com.example.chart.entities;

import java.util.UUID;

public class Vegetable
{
    private UUID id;
    private String name;
    private double price;
//    private double weight;
    private int amount;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Vegetable(UUID id, String name, double price, int amount) {
        this.id = id;
        this.name = name;
        this.price = price;
//        this.weight = weight;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    public double getWeight() {
//        return weight;
//    }
//
//    public void setWeight(double weight) {
//        this.weight = weight;
//    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "{" +
                id +
                "->" + name +
                "->" + price +
                "->" + amount ;
    }
}
