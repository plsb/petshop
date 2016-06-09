/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.usuario;

import br.util.GenericDAO;

/**
 *
 * @author Pedro Saraiva
 */
public class UsuarioDAO extends GenericDAO<Usuario>{

    public UsuarioDAO() {
        super(Usuario.class);
    }
    
}
