/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.contabancaria;

import br.contasreceber.ContasReceber;
import br.fornecedor.Fornecedor;
import br.util.GenericDAO;
import br.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.criterion.Restrictions;
import sun.net.www.content.text.Generic;

/**
 *
 * @author Pedro Saraiva
 */
public class ItemContaBancariaDAO extends GenericDAO<ItemContaBancaria> {
    
    public ItemContaBancariaDAO() {
        super(ItemContaBancaria.class);
    }
    
    public List<ItemContaBancaria> listaContas(ContaBancaria conta, Date iniDate, Date endDate) {
        List<ItemContaBancaria> lista = new ArrayList<>();
        try {
            setSessao(HibernateUtil.getSessionFactory().openSession());
            if (iniDate != null) {
                lista = getSessao().createCriteria(ItemContaBancaria.class)
                        .add(Restrictions.eq("contaBancaria", conta))
                        .add(Restrictions.ge("data", iniDate))
                        .add(Restrictions.le("data", endDate)).list();
            } else {
                lista = getSessao().createCriteria(ItemContaBancaria.class)
                        .add(Restrictions.eq("contaBancaria", conta))
                        .list();
            }
            
        } catch (Exception e) {
            getSessao().close();
        }
        return lista;
    }
    
    public double SaldoConta(ContaBancaria conta) {
        List<ItemContaBancaria> lista = new ArrayList<>();
        double saldo = 0;
        try {
            setSessao(HibernateUtil.getSessionFactory().openSession());
            
            lista = getSessao().createCriteria(ItemContaBancaria.class)
                    .add(Restrictions.eq("contaBancaria", conta))
                    .list();
            
            double entrada=0, saida=0;
            for (ItemContaBancaria lista1 : lista) {
                if(!lista1.isBloqueada()){
                    entrada += lista1.getEntrada();
                    saida += lista1.getSaida();
                }
            }
            saldo = entrada-saida;
            
        } catch (Exception e) {
            getSessao().close();
        }
        return saldo;
    }
    
}
