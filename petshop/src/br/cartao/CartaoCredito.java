/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cartao;

import br.venda.Venda;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CartaoCredito {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    private String bandeira;
    
    private int qtdParcelas;
    
    private String creditoDebito;
    
    @ManyToOne
    private Venda venda;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public int getQtdParcelas() {
        return qtdParcelas;
    }

    public void setQtdParcelas(int qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
    }

    public String getCreditoDebito() {
        return creditoDebito;
    }

    public void setCreditoDebito(String creditoDebito) {
        this.creditoDebito = creditoDebito;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.bandeira);
        hash = 53 * hash + this.qtdParcelas;
        hash = 53 * hash + Objects.hashCode(this.creditoDebito);
        hash = 53 * hash + Objects.hashCode(this.venda);
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
        final CartaoCredito other = (CartaoCredito) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.bandeira, other.bandeira)) {
            return false;
        }
        if (this.qtdParcelas != other.qtdParcelas) {
            return false;
        }
        if (!Objects.equals(this.creditoDebito, other.creditoDebito)) {
            return false;
        }
        if (!Objects.equals(this.venda, other.venda)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CartaoCredito{" + "id=" + id + ", bandeira=" + bandeira + ", qtdParcelas=" + qtdParcelas + ", creditoDebito=" + creditoDebito + ", venda=" + venda + '}';
    }
    
}
