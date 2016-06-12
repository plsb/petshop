/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.contabancaria;

import br.contaspagar.ContasPagar;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ItemContaBancaria implements Serializable, Comparable<ItemContaBancaria>{
    
    @Id
    @GeneratedValue
    private Integer id;
    
    private String descricao;
    
    @ManyToOne
    private ContaBancaria contaBancaria;
    
    private double entrada;
    
    private double saida;
    
    private boolean bloqueada;
    
    @ManyToOne
    private ContasPagar contaPagar;

    public ContasPagar getContaPagar() {
        return contaPagar;
    }

    public void setContaPagar(ContasPagar contaPagar) {
        this.contaPagar = contaPagar;
    }
    
    @Temporal(TemporalType.DATE)
    private Date data;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
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

    public ContaBancaria getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(ContaBancaria contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    public double getEntrada() {
        return entrada;
    }

    public void setEntrada(double entrada) {
        this.entrada = entrada;
    }

    public double getSaida() {
        return saida;
    }

    public void setSaida(double saida) {
        this.saida = saida;
    }

    public boolean isBloqueada() {
        return bloqueada;
    }

    public void setBloqueada(boolean bloqueada) {
        this.bloqueada = bloqueada;
    }
    
    public String getBloqueada(){
        if(bloqueada){
            return "B";
        } else {
            return "";
        }
    }

    @Override
    public int compareTo(ItemContaBancaria o) {
        return id.compareTo(o.id);
    }
    
}
