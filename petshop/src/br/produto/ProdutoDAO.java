/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.produto;

import br.util.GenericDAO;

/**
 *
 * @author Pedro Saraiva
 */
public class ProdutoDAO extends GenericDAO<Produto>{

    public ProdutoDAO() {
        super(Produto.class);
    }
    
}
