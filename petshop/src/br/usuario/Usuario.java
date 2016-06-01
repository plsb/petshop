package br.usuario;

import br.util.Util;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.UniqueConstraint;

@Entity
public class Usuario implements Comparable<Usuario>{
    
    @Id
    @GeneratedValue
    private Integer id;
    
    private String nome;
    
    private String login;
    
    private String senha;
    
    private boolean administrador, ativo;
    
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_permissao",
            uniqueConstraints = {
                @UniqueConstraint(columnNames = {"usuario", "permissao"})},
            joinColumns = @JoinColumn(name = "usuario"))
    @Column(name = "permissao", length = 50)
    private Set<String> permissao;// = new HashSet<String>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = Util.md5(senha);
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + Objects.hashCode(this.login);
        hash = 29 * hash + Objects.hashCode(this.senha);
        hash = 29 * hash + (this.administrador ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (this.administrador != other.administrador) {
            return false;
        }
        return true;
    }

    public Set<String> getPermissao() {
        return permissao;
    }

    public void setPermissao(Set<String> permissao) {
        this.permissao = permissao;
    }
    
    @Override
    public int compareTo(Usuario o) {
        return nome.compareTo(o.nome);
    }
    
    public String getAdministrador(){
        if(administrador){
            return "Administrador";
        } else {
            return "";
        }
    }
    
    public String getAtivo(){
        if(ativo){
            return "Ativo";
        } else {
            return "Inativo";
        }
    }

    
}
