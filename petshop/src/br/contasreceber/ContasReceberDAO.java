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
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Pedro Saraiva
 */
public class ContasReceberDAO extends GenericDAO<ContasReceber>{

    public ContasReceberDAO() {
        super(ContasReceber.class);
    }
    
    public List<ContasReceber> listaContasClienteEmAtraso(Cliente c){
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
    
    public List<ContasReceber> listaContasCliente(Cliente c, boolean paga){
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
    
    
}
