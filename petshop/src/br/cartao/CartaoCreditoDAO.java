/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cartao;

import br.util.GenericDAO;

/**
 *
 * @author Pedro Saraiva
 */
public class CartaoCreditoDAO extends GenericDAO<CartaoCredito>{

    public CartaoCreditoDAO() {
        super(CartaoCredito.class);
    }
    
}
