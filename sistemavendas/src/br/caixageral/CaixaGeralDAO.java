/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.caixageral;

import br.util.GenericDAO;
import br.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Pedro Saraiva
 */
public class CaixaGeralDAO extends GenericDAO<CaixaGeral>{

    public CaixaGeralDAO() {
        super(CaixaGeral.class);
    }
    
    public double saldoConta() {
        List<CaixaGeral> lista = new ArrayList<>();
        double saldo = 0;
        try {
            setSessao(HibernateUtil.getSessionFactory().openSession());
            
            lista = getSessao().createCriteria(CaixaGeral.class).list();
            
            double entrada=0, saida=0;
            for (CaixaGeral lista1 : lista) {
                    entrada += lista1.getValorEntrada();
                    saida += lista1.getValorSaida();
            }
            saldo = entrada-saida;
            
        } catch (Exception e) {
            getSessao().close();
        }
        return saldo;
    }
    
}
