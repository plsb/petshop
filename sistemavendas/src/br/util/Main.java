/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.util;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

/**
 *
 * @author Pedro Saraiva
 */
public class Main {

    public static void main(String[] args) throws URISyntaxException, InterruptedException {
//        try {
//            File file = new File("Backup");
//            file.mkdir();
//            String nomeBkp = "sistemaBKP.sql";
//            String dump = "cmd.exe /c mysqldump --user=root --password=root copex > " + nomeBkp;
//            Runtime bkp = Runtime.getRuntime();
//            bkp.exec(dump);
//            JOptionPane.showMessageDialog(null, "Backup realizado com sucesso!");
//        } catch (IOException ex) {
//            JOptionPane.showMessageDialog(null, "erro" + ex.getMessage());
//        }
        
        int i=2,j=8;
        int n = j%i;
        System.out.println(n);
    }

}
