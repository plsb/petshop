/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.orcamento;

import br.util.GenericDAO;

/**
 *
 * @author Pedro Saraiva
 */
public class ItemOrcamentoDAO extends GenericDAO<ItemOrcamento>{

    public ItemOrcamentoDAO() {
        super(ItemOrcamento.class);
    }
    
}
