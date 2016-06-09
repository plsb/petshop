/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.empresa;

import br.util.GenericDAO;

/**
 *
 * @author Pedro Saraiva
 */
public class EmpresaDAO extends GenericDAO<Empresa>{

    public EmpresaDAO() {
        super(Empresa.class);
    }
    
}
