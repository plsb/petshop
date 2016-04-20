/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.livro;

import br.venda.Venda;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class LivroCaixa implements Comparable<LivroCaixa>{
    
    @Id
    @GeneratedValue
    private Integer id;
    
    private String descricao;
    
    private double valorEntrada;
    
    private double valorSaida;
    
    @Temporal(TemporalType.DATE)
    private Date data;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    @ManyToOne
    private Venda venda;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(double valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public double getValorSaida() {
        return valorSaida;
    }

    public void setValorSaida(double valorSaida) {
        this.valorSaida = valorSaida;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.valorEntrada) ^ (Double.doubleToLongBits(this.valorEntrada) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.valorSaida) ^ (Double.doubleToLongBits(this.valorSaida) >>> 32));
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
        final LivroCaixa other = (LivroCaixa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorEntrada) != Double.doubleToLongBits(other.valorEntrada)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorSaida) != Double.doubleToLongBits(other.valorSaida)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LivroCaixa{" + "id=" + id + ", valorEntrada=" + valorEntrada + ", valorSaida=" + valorSaida + '}';
    }

    @Override
    public int compareTo(LivroCaixa o) {
        return id.compareTo(o.id);
    }
    
}
