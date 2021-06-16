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
public class Wallet {

    String walletId;
    String userId;
    String companyId;
    String companyRoleId;
    String validityDate;

    public Wallet(String userId, String companyId, String companyRoleId, String validityDate) {
        UUID uuidWallet = UUID.randomUUID();
        this.walletId = uuidWallet.toString();
        this.userId = userId;
        this.companyId = companyId;
        this.companyRoleId = companyRoleId;
        this.validityDate = validityDate;
    }

    public String getId() {
        return walletId;
    }

    public void setId(String id) {
        this.walletId = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyRoleId() {
        return companyRoleId;
    }

    public void setCompanyRoleId(String companyRoleId) {
        this.companyRoleId = companyRoleId;
    }

    public String getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(String validityDate) {
        this.validityDate = validityDate;
    }

}
