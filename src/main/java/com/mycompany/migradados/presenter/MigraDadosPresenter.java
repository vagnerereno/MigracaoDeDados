/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.migradados.presenter;

import com.mycompany.migradados.entity.CsvSingleFile;
import com.mycompany.migradados.entity.User;
import com.mycompany.migradados.entity.Wallet;
import com.mycompany.migradados.interactor.FileInteractor;
import com.mycompany.migradados.interactor.MigraDadosInteractor;
import com.mycompany.migradados.view.MigraDadosView;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author vagne
 */
public class MigraDadosPresenter {

    MigraDadosInteractor migraDadosInteractor;
    FileInteractor fileInteractor;
    MigraDadosView view;

    public MigraDadosPresenter(MigraDadosView view) {
        this.view = view;
        this.migraDadosInteractor = new MigraDadosInteractor(this);
        this.fileInteractor = new FileInteractor(this);
    }

    public void insertUsers(User user) {
        migraDadosInteractor.insertUser(user);
    }

    public void insertWallets(Wallet wallet) {
        migraDadosInteractor.insertWallet(wallet);
    }

    public void onUserRegistred(String message) {
        view.showMessage(message);
    }

    public void onWalletRegistred(String message) {
        view.showMessage(message);
    }

    public void onError(String message) {
        view.showErrorMessage(message);
    }

    public void readCsv(String migracaocsv, String companyId, String CompanyRoleId) throws IOException {
        List<CsvSingleFile> data = fileInteractor.readFile(migracaocsv);
        for (CsvSingleFile file : data) {
            User user = new User(file.getName(), file.getTaxNumber(), file.getPhoneNumber(), file.getEmail());
            Wallet wallet = new Wallet(user.getId(), companyId, CompanyRoleId, file.getValidityDate());
            try {
                if (migraDadosInteractor.insertUser(user)) {
                    migraDadosInteractor.insertWallet(wallet);
                }
            } catch (Exception e) {
                view.showErrorMessage(e.getLocalizedMessage());
            }
        }
    }
}
