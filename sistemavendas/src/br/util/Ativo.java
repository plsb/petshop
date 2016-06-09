/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.util;

import br.livro.Caixa;
import br.usuario.Usuario;

/**
 *
 * @author Pedro Saraiva
 */
public class Ativo {
    
    private static Usuario usuario;
    
    private static Caixa caixa;

    public static Caixa getCaixa() {
        return caixa;
    }

    public static void setCaixa(Caixa caixa) {
        Ativo.caixa = caixa;
    }
    
    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        Ativo.usuario = usuario;
    }
    
}
