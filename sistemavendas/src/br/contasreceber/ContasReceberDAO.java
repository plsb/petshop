/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.contasreceber;

import br.cliente.Cliente;
import br.util.GenericDAO;
import br.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Pedro Saraiva
 */
public class ContasReceberDAO extends GenericDAO<ContasReceber> {

    public ContasReceberDAO() {
        super(ContasReceber.class);
    }

    public List<ContasReceber> listaContasClienteEmAtraso(Cliente c) {
        List<ContasReceber> lista = new ArrayList<>();
        try {
            setSessao(HibernateUtil.getSessionFactory().openSession());
            lista = getSessao().createCriteria(ContasReceber.class).add(Restrictions.eq("cliente", c)
            ).add(Restrictions.le("dataVencimento", new Date()))
                    .add(Restrictions.eq("paga", false)).list();
        } catch (Exception e) {
            getSessao().close();
        }
        return lista;
    }

    public List<ContasReceber> listaContasCliente(Cliente c, boolean paga) {
        List<ContasReceber> lista = new ArrayList<>();
        try {
            setSessao(HibernateUtil.getSessionFactory().openSession());
            lista = getSessao().createCriteria(ContasReceber.class).add(Restrictions.eq("cliente", c)
            ).add(Restrictions.eq("paga", paga)).list();
        } catch (Exception e) {
            getSessao().close();
        }
        return lista;
    }

    public List<ContasReceber> listaContasCliente(Cliente c, boolean paga, Date iniDate, Date endDate) {
        List<ContasReceber> lista = new ArrayList<>();
        try {
            setSessao(HibernateUtil.getSessionFactory().openSession());
            if (c != null) {
                lista = getSessao().createCriteria(ContasReceber.class)
                        .add(Restrictions.eq("cliente", c)).
                        add(Restrictions.eq("paga", paga))
                        .add(Restrictions.ge("dataVencimento", iniDate))
                        .add(Restrictions.le("dataVencimento", endDate)).list();
            } else {
                lista = getSessao().createCriteria(ContasReceber.class)
                        .add(Restrictions.eq("paga", paga))
                        .add(Restrictions.ge("dataVencimento", iniDate))
                        .add(Restrictions.le("dataVencimento", endDate)).list();
            }

        } catch (Exception e) {
            getSessao().close();
        }
        return lista;
    }

    public List<ContasReceber> listContasEntreDatas(Date dataIni, Date dataFim) {
        List<ContasReceber> lista = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            lista = this.getSessao().createCriteria(ContasReceber.class)
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
