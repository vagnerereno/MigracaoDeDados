/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.migradados.interactor;

import com.mycompany.migradados.entity.User;
import com.mycompany.migradados.entity.Wallet;
import com.mycompany.migradados.presenter.MigraDadosPresenter;

/**
 *
 * @author vagne
 */
public class MigraDadosInteractor {

    MigraDadosPresenter presenter;
    
    public MigraDadosInteractor (MigraDadosPresenter presenter) {
        this.presenter = presenter;
    }
    
    public boolean insertUser(User user) {

        DBConnection connection = new DBConnection();
        String insertUsers = "INSERT INTO public.users (id, name, tax_number, password, phone_number, email) "
                + "VALUES ('" + user.getId() + "', '" + user.getName() + "',"
                + " '" + user.getTaxNumber() + "', '" + user.getTaxNumber() + "',"
                + " '" + user.getPhoneNumber() + "',  '" + user.getEmail() + "');";
        String result = connection.executaSql(insertUsers);
        
        if (result.toLowerCase().contains("sucesso".toLowerCase())) {
            presenter.onUserRegistred("Usuários inseridos com sucesso.");
            return true;
        } else {
            presenter.onError("Erro ao inserir usuários: " + result);
            return false;
        }
    }

    public void insertWallet(Wallet wallet) {

        DBConnection connection = new DBConnection();

        String insertWallets = "INSERT INTO public.wallets(id, user_id, company_id, company_role_id, validity_date) "
                + " VALUES ('" + wallet.getId() + "', '" + wallet.getUserId() + "', "
                + "'" + wallet.getCompanyId() + "', " + "'" + wallet.getCompanyRoleId() + "', "
                + "'" + wallet.getValidityDate() + "');";
        String result = connection.executaSql(insertWallets);
        
        if (result.toLowerCase().contains("sucesso".toLowerCase())) {
            presenter.onWalletRegistred("Carteirinhas inseridas com sucesso.");
        } else {
            presenter.onError("Erro ao inserir carteirinhas: " + result);
        }
    }
}
