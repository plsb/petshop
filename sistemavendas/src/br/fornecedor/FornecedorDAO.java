/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fornecedor;

import br.util.GenericDAO;

/**
 *
 * @author Pedro Saraiva
 */
public class FornecedorDAO extends GenericDAO<Fornecedor>{

    public FornecedorDAO() {
        super(Fornecedor.class);
    }
    
}
