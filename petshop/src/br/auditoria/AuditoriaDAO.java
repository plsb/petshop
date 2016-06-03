/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.auditoria;

import br.util.GenericDAO;
import br.util.UsuarioAtivo;
import java.util.Date;

/**
 *
 * @author Pedro Saraiva
 */
public class AuditoriaDAO extends GenericDAO<Auditoria>{

    public AuditoriaDAO() {
        super(Auditoria.class);
    }
    
    public void adicionaAuditoria(String classe, String descricao){
        Auditoria a = new Auditoria();
        a.setData(new Date());
        a.setHora(new Date());
        a.setUser(UsuarioAtivo.getUsuario());
        a.setDescricao(descricao);
        a.setClasse(classe);
        
        AuditoriaDAO aDAO = new AuditoriaDAO();
        aDAO.add(a);
    }
    
}



