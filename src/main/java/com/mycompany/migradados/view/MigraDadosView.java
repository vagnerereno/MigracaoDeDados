/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.migradados.view;

import com.mycompany.migradados.presenter.MigraDadosPresenter;
import java.io.IOException;

/**
 *
 * @author vagne
 */
public class MigraDadosView {

    MigraDadosPresenter presenter;

    public MigraDadosView() {
        this.presenter = new MigraDadosPresenter(this);
    }
    
    public static void main(String[] args) throws IOException {
        String companyRoleId = "9c13f686-2d88-46b1-a770-230624ed2bdb";
        String companyId = "919d1f27-e1e1-451f-874a-4bdd970b69cf";
        
        MigraDadosView migraDadosView = new MigraDadosView();

        migraDadosView.readCsv("migracao.csv", companyId, companyRoleId);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showErrorMessage(String message) {
        System.err.println(message);
    }

    private void readCsv(String migracaocsv, String companyId, String companyRoleId) throws IOException {
        presenter.readCsv(migracaocsv, companyId, companyRoleId);
    }
}
