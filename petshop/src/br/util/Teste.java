/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pelusb
 */
public class Teste {

    public static void main(String[] args) {
        Date dt = new Date();
        SimpleDateFormat dfdtDataNascimento;
        SimpleDateFormat s = new SimpleDateFormat("ddMMyy");
        SimpleDateFormat s2 = new SimpleDateFormat("hhmm");

        System.out.println(s.format(dt)+s2.format(dt));

    }
}
