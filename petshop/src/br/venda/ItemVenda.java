/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.venda;

import br.produto.Produto;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemVenda implements Comparable<ItemVenda>, Serializable {

    
    public ItemVenda() {
        cancelado = false;
    }

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Venda venda;

    @ManyToOne
    private Produto produto;

    private double quantidade;

    private Integer ordem;

    private boolean cancelado;

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.venda);
        hash = 83 * hash + Objects.hashCode(this.produto);
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
        final ItemVenda other = (ItemVenda) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.venda, other.venda)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItensVenda{" + "id=" + id + ", venda=" + venda + ", produto=" + produto + '}';
    }

    public double getParcial() {
        if (cancelado != true) {
            return quantidade * produto.getPrecoVenda();
        }
        return 0;
    }

    public double getDesconto() {
        double desconto = 0;
        if (venda.getTipoPagamento().equals("VV") && cancelado != true) {
            if (produto.getGrupoProduto().getDescontoAVista() > 0) {
                desconto = getParcial() * (produto.getGrupoProduto().getDescontoAVista() / 100);
            }
        }
        return desconto;
    }

    public String getSubtotal() {
        if (cancelado != true) {
            return String.valueOf(getParcial() - getDesconto());
        }
        return "Cancelado";
    }

    @Override
    public int compareTo(ItemVenda o) {
        if (ordem < o.ordem) {
            return -1;
        }
        if (ordem > o.ordem) {
            return 1;
        }

        return 0;
    }
    private static final long serialVersionUID = -8889175823235580473L;

}
