/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cliente;

import br.util.GenericDAO;

/**
 *
 * @author Pedro Saraiva
 */
public class ClienteDAO extends GenericDAO<Cliente>{

    public ClienteDAO() {
        super(Cliente.class);
    }
    
}
