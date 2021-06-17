/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.migradados.view;

import com.mycompany.migradados.interactor.DBConnection;
import com.mycompany.migradados.presenter.MigraDadosPresenter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vagne
 */
public class MigraDadosView {

    MigraDadosPresenter presenter;

    public MigraDadosView() {
        this.presenter = new MigraDadosPresenter(this);
    }

    public static void main(String[] args) {
        String companyRoleId = "9c13f686-2d88-46b1-a770-230624ed2bdb";
        String companyId = "919d1f27-e1e1-451f-874a-4bdd970b69cf";
        String file = "migracao.csv";

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-h":
                    System.out.println("-h --help to options menu");
                    System.out.println("-i --input [DEFAULT= migracao.csv, FORMAT= name,taxNumber,phoneNumber,email,validityDate]");
                    System.out.println("-H --host [DEFAULT= jdbc:postgresql://localhost]");
                    System.out.println("-P --port [DEFAULT= 5432]");
                    System.out.println("-n --name [DB_NAME DEFAULT= inovadigital]");
                    System.out.println("-u --user [DB_USER DEFAULT= postgres]");
                    System.out.println("-p --password [DB_PASSWORD DEFAULT= database]");
                    System.out.println("-c --companyid [DEFAULT= 9c13f686-2d88-46b1-a770-230624ed2bdb]");
                    System.out.println("-r --companyroleid [DEFAULT= 919d1f27-e1e1-451f-874a-4bdd970b69cf]");
                    System.exit(0);
                case "--help":
                    System.out.println("-h --help to options menu");
                    System.out.println("-i --input [DEFAULT= migracao.csv, FORMAT= name,taxNumber,phoneNumber,email,validityDate]");
                    System.out.println("-H --host [DEFAULT= jdbc:postgresql://localhost]");
                    System.out.println("-P --port [DEFAULT= 5432]");
                    System.out.println("-n --name [DB_NAME DEFAULT= inovadigital]");
                    System.out.println("-u --user [DB_USER DEFAULT= postgres]");
                    System.out.println("-p --password [DB_PASSWORD DEFAULT= database]");
                    System.out.println("-c --companyid [DEFAULT= 9c13f686-2d88-46b1-a770-230624ed2bdb]");
                    System.out.println("-r --companyroleid [DEFAULT= 919d1f27-e1e1-451f-874a-4bdd970b69cf]");
                    System.exit(0);
                    break;
                case "-i":
                    file = args[i + 1];
                    break;
                case "--input":
                    file = args[i + 1];
                    break;
                case "-H":
                    DBConnection.PG_HOST = args[i + 1];
                    break;
                case "--host":
                    DBConnection.PG_HOST = args[i + 1];
                    break;
                case "-P":
                    DBConnection.PG_PORT = args[i + 1];
                    break;
                case "--port":
                    DBConnection.PG_PORT = args[i + 1];
                    break;
                case "-n":
                    DBConnection.PG_DB_NAME = args[i + 1];
                    break;
                case "--name":
                    DBConnection.PG_DB_NAME = args[i + 1];
                    break;
                case "-u":
                    DBConnection.PG_USER = args[i + 1];
                    break;
                case "--user":
                    DBConnection.PG_USER = args[i + 1];
                    break;
                case "-p":
                    DBConnection.PG_PASSWORD = args[i + 1];
                    break;
                case "--password":
                    DBConnection.PG_PASSWORD = args[i + 1];
                    break;
                case "-c":
                    companyId = args[i + 1];
                    break;
                case "--companyid":
                    companyId = args[i + 1];
                    break;
                case "-r":
                    companyRoleId = args[i + 1];
                    break;
                case "--companyroleid":
                    companyRoleId = args[i + 1];
                    break;
            }
            i = i + 1;
        }

        MigraDadosView migraDadosView = new MigraDadosView();

        try {
            migraDadosView.readCsv(file, companyId, companyRoleId);
        } catch (IOException ex) {
            System.out.println("Não foi possível encontrar o seu arquivo.");
        }
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
