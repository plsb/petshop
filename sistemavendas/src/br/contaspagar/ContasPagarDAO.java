/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.contaspagar;

import br.contasreceber.ContasReceber;
import br.fornecedor.Fornecedor;
import br.util.GenericDAO;
import br.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Pedro Saraiva
 */
public class ContasPagarDAO extends GenericDAO<ContasPagar>{

    public ContasPagarDAO() {
        super(ContasPagar.class);
    }

    public List<ContasPagar> listaContasFornecedor(Fornecedor fornecedor, 
            boolean paga, Date iniDate, Date endDate) {
        List<ContasPagar> lista = new ArrayList<>();
        try {
            setSessao(HibernateUtil.getSessionFactory().openSession());
            if (fornecedor != null) {
                lista = getSessao().createCriteria(ContasPagar.class)
                        .add(Restrictions.eq("fornecedor", fornecedor)).
                        add(Restrictions.eq("paga", paga))
                        .add(Restrictions.ge("dataVencimento", iniDate))
                        .add(Restrictions.le("dataVencimento", endDate)).list();
            } else {
                lista = getSessao().createCriteria(ContasPagar.class)
                        .add(Restrictions.eq("paga", paga))
                        .add(Restrictions.ge("dataVencimento", iniDate))
                        .add(Restrictions.le("dataVencimento", endDate)).list();
            }

        } catch (Exception e) {
            getSessao().close();
        }
        return lista;
    }
    
}
