/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.livro;

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
public class LivroCaixaDAO extends GenericDAO<LivroCaixa> {
    
    public LivroCaixaDAO() {
        super(LivroCaixa.class);
    }
    
    public List<LivroCaixa> listCaixaPorUsuario(Date data) {
        List<LivroCaixa> lista = new ArrayList<>();
        try {   
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            CaixaDAO cDAO = new CaixaDAO();
            List<Caixa> listCaixa = cDAO.listCaixaAbertoUsuario(Ativo.getUsuario(), new Date());
            if (listCaixa.size() > 0) {
                
                setTransacao(getSessao().beginTransaction());
                lista = this.getSessao().createCriteria(LivroCaixa.class).
                        add(Restrictions.eq("caixa", listCaixa.get(0))).list();
                lista = new ArrayList(new HashSet(lista));
            }
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
