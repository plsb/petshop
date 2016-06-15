/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cartao;

import br.cliente.Cliente;
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
public class CartaoCredito implements Comparable<CartaoCredito>{
    
    @Id
    @GeneratedValue
    private Integer id;
    
    private String descricao;
    
    private String bandeira;
    
    private int qtdParcelas;
    
    private boolean debito;
    
    @ManyToOne
    private Venda venda;
    
    @ManyToOne
    private Cliente cliente;
    
    @Temporal(TemporalType.DATE)
    private Date data;
    
    private double valor;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
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
        if (!Objects.equals(this.venda, other.venda)) {
            return false;
        }
        return true;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isDebito() {
        return debito;
    }

    public void setDebito(boolean debito) {
        this.debito = debito;
    }

    @Override
    public String toString() {
        return "CartaoCredito{" + "id=" + id + ", bandeira=" + bandeira + ", qtdParcelas=" + qtdParcelas + ", debito=" + debito + ", venda=" + venda + ", valor=" + valor + '}';
    }

    @Override
    public int compareTo(CartaoCredito o) {
        return o.id.compareTo(id);
    }
    
    public String getTipo(){
        if(isDebito()){
            return "Débito";
        } 
        return "Crédito";
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
}
