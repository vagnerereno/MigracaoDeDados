/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.migradados.entity;

/**
 *
 * @author vagne
 */
public class CsvSingleFile {
    
    String name;
    String taxNumber;
    String phoneNumber;
    String email;
    String validityDate;    

    public CsvSingleFile() {
    }
    
    public CsvSingleFile(String name, String taxNumber, String phoneNumber, String email, String validityDate) {
        this.name = name;
        this.taxNumber = taxNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.validityDate = validityDate;
    }
    
    public String toString () {
        return "CsvSingleFile{name='" + name + "\', "
                + "taxNumber='" + taxNumber + "', phoneNumber='" + phoneNumber + "', email='" + email + "', "
                + "validityDate='" + validityDate + "\'}";
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

    public String getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(String validityDate) {
        this.validityDate = validityDate;
    }
}
