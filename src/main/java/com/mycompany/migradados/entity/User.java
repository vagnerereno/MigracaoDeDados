/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.migradados.entity;

import java.util.UUID;

/**
 *
 * @author vagne
 */
public class User {

    String userId;
    String name;
    String taxNumber;
    String phoneNumber;
    String email;

    public User(String name, String taxNumber, String phoneNumber, String email) {
        UUID uuidUser = UUID.randomUUID();
        this.userId = uuidUser.toString();
        this.name = name;
        this.taxNumber = taxNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getId() {
        return userId;
    }

    public void setId(String id) {
        this.userId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
