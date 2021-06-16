/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.migradados.interactor;

import com.mycompany.migradados.entity.CsvSingleFile;
import com.mycompany.migradados.entity.User;
import com.mycompany.migradados.entity.Wallet;
import com.mycompany.migradados.presenter.MigraDadosPresenter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author vagne
 */
public class FileInteractor {

    MigraDadosPresenter presenter;

    public FileInteractor(MigraDadosPresenter presenter) {
        this.presenter = presenter;
    }

    public void readFile(String fileName) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(fileName));

        CsvToBean<CsvSingleFile> csvToBean = new CsvToBeanBuilder(reader)
               .withType(CsvSingleFile.class)
               .build();

        System.out.println("Antes da lista");
        List<CsvSingleFile> csvSingleFiles = csvToBean.parse();
        System.out.println("Depois da lista");

       for (CsvSingleFile csvSingleFile : csvSingleFiles) {
           System.out.println(csvSingleFile);
        }
    }

}
