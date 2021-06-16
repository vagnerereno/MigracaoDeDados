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
public class CsvPessoa {
   private String nome;
    private Integer idade;
    private String email;

    // Gets e Sets omitidos para ficar menor

    public String toString() {
        return "CsvPessoa{nome='" + nome + "\', idade=" + idade + ", email='" + email + "\'}";
    }
}
