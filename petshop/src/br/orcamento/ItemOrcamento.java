/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.orcamento;

import br.produto.Produto;
import br.venda.ItemVenda;
import br.venda.Venda;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Pedro Saraiva
 */
@Entity
public class ItemOrcamento implements Comparable<ItemOrcamento>, Serializable {

    @Override
    public String toString() {
        return "ItemOrcamento{" + "id=" + id + ", orcamento=" + orcamento + ", produto=" + produto + ", quantidade=" + quantidade + ", ordem=" + ordem + '}';
    }

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Orcamento orcamento;

    @ManyToOne
    private Produto produto;

    private double quantidade;

    private Integer ordem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.orcamento);
        hash = 89 * hash + Objects.hashCode(this.produto);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.quantidade) ^ (Double.doubleToLongBits(this.quantidade) >>> 32));
        hash = 89 * hash + Objects.hashCode(this.ordem);
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
        final ItemOrcamento other = (ItemOrcamento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.orcamento, other.orcamento)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        if (Double.doubleToLongBits(this.quantidade) != Double.doubleToLongBits(other.quantidade)) {
            return false;
        }
        if (!Objects.equals(this.ordem, other.ordem)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(ItemOrcamento o) {
        if (ordem < o.ordem) {
            return -1;
        }
        if (ordem > o.ordem) {
            return 1;
        }

        return 0;
    }
    private static final long serialVersionUID = 7983345259045910410L;

    public double getParcial() {
        return quantidade * produto.getPrecoVenda();
    }

    public double getDesconto() {
        double desconto = 0;
        if (orcamento.getTipoPagamento().equals("VV")) {
            if (produto.getGrupoProduto().getDescontoAVista() > 0) {
                desconto = getParcial() * (produto.getGrupoProduto().getDescontoAVista() / 100);
            }
        }
        return desconto;
    }

    public String getSubtotal() {
        return String.valueOf(getParcial() - getDesconto());
    }
}
