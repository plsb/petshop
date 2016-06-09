/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.livro;

import br.usuario.Usuario;
import br.util.GenericDAO;
import br.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class CaixaDAO extends GenericDAO<Caixa>{

    public CaixaDAO() {
        super(Caixa.class);
    }
    
    
    public List<Caixa> listCaixaAbertoUsuario(Usuario usuario, Date data) {
        List<Caixa> lista = null;
        try {           
                        
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            lista = this.getSessao().createCriteria(Caixa.class).
                    add(Restrictions.eq("user", usuario)).
                    add(Restrictions.eq("aberto", true)).list();
            lista = new ArrayList(new HashSet(lista));
        } catch (Throwable e) {
            if (getTransacao().isActive()) {
                getTransacao().rollback();
            }
            System.out.println(e.getMessage());
//            JOptionPane.showMessageDialog(null, "Não foi possível listar: " + e.getMessage());
        } finally {
            getSessao().close();
        }
        return lista;

    }
    
    
    
    public List<Caixa> listCaixaAberto(String nrCaixa) {
        List<Caixa> lista = null;
        try {           
                        
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            lista = this.getSessao().createCriteria(Caixa.class).
                    add(Restrictions.eq("nrCaixa", nrCaixa)).
                    add(Restrictions.eq("aberto", true)).list();
            lista = new ArrayList(new HashSet(lista));
        } catch (Throwable e) {
            if (getTransacao().isActive()) {
                getTransacao().rollback();
            }
            System.out.println(e.getMessage());
//            JOptionPane.showMessageDialog(null, "Não foi possível listar: " + e.getMessage());
        } finally {
            getSessao().close();
        }
        return lista;

    }
    
    public Caixa listCaixaAnterior(Caixa c) {
        List<Caixa> lista = null;
        Caixa caixa = null;
        try {           
                        
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            lista = this.getSessao().createCriteria(Caixa.class).
                    add(Restrictions.eq("nrCaixa", c.getNrCaixa())).list();
            lista = new ArrayList(new HashSet(lista));
            Collections.sort(lista);
            if(lista.size()>1){
                caixa = lista.get(1);
            }
        } catch (Throwable e) {
            if (getTransacao().isActive()) {
                getTransacao().rollback();
            }
            System.out.println(e.getMessage());
//            JOptionPane.showMessageDialog(null, "Não foi possível listar: " + e.getMessage());
        } finally {
            getSessao().close();
        }
        return caixa;

    }
    
}
