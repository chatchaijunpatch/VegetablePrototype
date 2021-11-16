package com.example.chart.entities;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


public class VegOrder
{
    private UUID order_Id;
    private Date date;
    private String name;
    private String surname;
    private String mobile;
    private String address;
    private String vegetable ;
    private String email;
    private List<Cart> cartList = new ArrayList<>();
    private int amount;
    private String username;
    private Double price;
    private String status;
    private Date payment;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void add(Cart cartList) {
        this.cartList.add(cartList);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public UUID getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(UUID order_Id) {
        this.order_Id = order_Id;
    }

    public void setPayment(Date payment) {
        this.payment = payment;
    }

    public Date getPayment() {
        return payment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVegetable() {
        return vegetable;
    }

    public void setVegetable(String vegetable) {
        this.vegetable = vegetable  ;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
