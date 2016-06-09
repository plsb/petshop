/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.orcamento;

import br.util.GenericDAO;
import br.util.HibernateUtil;
import br.venda.Venda;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Pedro Saraiva
 */
public class OrcamentoDAO extends GenericDAO<Orcamento>{

    public OrcamentoDAO() {
        super(Orcamento.class);
    }
    
    public List<Orcamento> listOrcamentoEntreDatas(Date dataIni, Date dataFim) {
        List<Orcamento> lista = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            lista = this.getSessao().createCriteria(Orcamento.class)
                    .add(Restrictions.ge("data", dataIni))
                    .add(Restrictions.le("data", dataFim)).list();
            lista = new ArrayList(new HashSet(lista));
        } catch (Throwable e) {
            if (getTransacao().isActive()) {
                getTransacao().rollback();
            }
//            JOptionPane.showMessageDialog(null, "Não foi possível listar: " + e.getMessage());
        } finally {
            getSessao().close();
        }
        return lista;

    }
    
}
