/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.grupo_produto;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class GrupoProduto implements Comparable<GrupoProduto>{
    
    @Id
    @GeneratedValue
    private Integer id;
    
    private String descricao;
    
    private double descontoAVista;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getDescontoAVista() {
        return descontoAVista;
    }

    public void setDescontoAVista(double descontoAVista) {
        this.descontoAVista = descontoAVista;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.descricao);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.descontoAVista) ^ (Double.doubleToLongBits(this.descontoAVista) >>> 32));
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
        final GrupoProduto other = (GrupoProduto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (Double.doubleToLongBits(this.descontoAVista) != Double.doubleToLongBits(other.descontoAVista)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GrupoProduto{" + "id=" + id + ", descricao=" + descricao + ", descontoAVista=" + descontoAVista + '}';
    }

    @Override
    public int compareTo(GrupoProduto o) {
        return descricao.compareTo(o.descricao);
    }
    
    
    
}
