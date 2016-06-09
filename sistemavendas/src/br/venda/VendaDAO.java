/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.venda;

import br.util.Ativo;
import br.util.GenericDAO;
import br.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Pedro Saraiva
 */
public class VendaDAO extends GenericDAO<Venda>{

    public VendaDAO() {
        super(Venda.class);
    }
    
    public List<Venda> listVendaEntreDatas(Date dataIni, Date dataFim) {
        List<Venda> lista = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            lista = this.getSessao().createCriteria(Venda.class)
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
    
    public List<Venda> listVendaEntreDatasPorUsuario(Date dataIni, Date dataFim) {
        List<Venda> lista = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            lista = this.getSessao().createCriteria(Venda.class)
                    .add(Restrictions.ge("data", dataIni))
                    .add(Restrictions.le("data", dataFim))
                    .add(Restrictions.eq("usuario", Ativo.getUsuario())).list();
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
