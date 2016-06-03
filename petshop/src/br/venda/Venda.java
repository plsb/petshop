/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.venda;

import br.cliente.Cliente;
import br.usuario.Usuario;
import br.vendedor.Vendedor;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Venda implements Comparable<Venda>, Serializable{
    
       
    @Id
    @GeneratedValue
    private Integer id;
    
    @Temporal(TemporalType.DATE)
    private Date data;
    
    @Temporal(TemporalType.TIME)
    private Date hora;
    
    @ManyToOne
    private Vendedor vendedor;
    
    @ManyToOne
    private Usuario usuario;
    
    @ManyToOne
    private Cliente cliente;
    
    private double desconto;
    
    private double valorTotal;
    
    private String tipoPagamento;
    
    private boolean cancelada;
    
    private double vlVista, vlPromissoria, vlCartao;

    public double getVlVista() {
        return vlVista;
    }

    public void setVlVista(double vlVista) {
        this.vlVista = vlVista;
    }

    public double getVlPromissoria() {
        return vlPromissoria;
    }

    public void setVlPromissoria(double vlPromissoria) {
        this.vlPromissoria = vlPromissoria;
    }

    public double getVlCartao() {
        return vlCartao;
    }

    public void setVlCartao(double vlCartao) {
        this.vlCartao = vlCartao;
    }
    
    public boolean isCancelada() {
        return cancelada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }
    
    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.data);
        hash = 23 * hash + Objects.hashCode(this.vendedor);
        hash = 23 * hash + Objects.hashCode(this.cliente);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.desconto) ^ (Double.doubleToLongBits(this.desconto) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.valorTotal) ^ (Double.doubleToLongBits(this.valorTotal) >>> 32));
        hash = 23 * hash + Objects.hashCode(this.tipoPagamento);
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
        final Venda other = (Venda) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.vendedor, other.vendedor)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (Double.doubleToLongBits(this.desconto) != Double.doubleToLongBits(other.desconto)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorTotal) != Double.doubleToLongBits(other.valorTotal)) {
            return false;
        }
        if (!Objects.equals(this.tipoPagamento, other.tipoPagamento)) {
            return false;
        }
        return true;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", data=" + data + ", vendedor=" + vendedor + ", cliente=" + cliente + ", desconto=" + desconto + ", valorTotal=" + valorTotal + ", tipoPagamento=" + tipoPagamento + '}';
    }

    @Override
    public int compareTo(Venda o) {
        return o.id.compareTo(id);
    }
    private static final long serialVersionUID = -289875782100734286L;
    
}
