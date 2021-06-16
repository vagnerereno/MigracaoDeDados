/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.migradados.interactor;

import com.mycompany.migradados.entity.CsvPessoa;
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
public class LerLinhasComoObjetosOpenCsv {

    public static void main(String[] args) throws IOException {

        Reader reader = Files.newBufferedReader(Paths.get("migracao.csv"));

        CsvToBean<CsvPessoa> csvToBean = new CsvToBeanBuilder(reader)
                .withType(CsvPessoa.class)
                .build();

        List<CsvPessoa> pessoas = csvToBean.parse();

        for (CsvPessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }
    }
}
