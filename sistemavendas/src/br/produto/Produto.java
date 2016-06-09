/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.produto;

import br.fornecedor.Fornecedor;
import br.grupo_produto.GrupoProduto;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Produto implements Comparable<Produto>{
    
    @Id
    @GeneratedValue
    private Integer id;
    
    private String codigo;
    
    private String referencia;
    
    @ManyToOne
    private GrupoProduto grupoProduto;
    
    @ManyToOne
    private Fornecedor fornecedor;
    
    private boolean servico;
    
    private String descricao;
    
    private double qtdEstoque;
    
    private double precoVenda;
    
    private double precoCusto;
    
    private double estoqueMinimo;
    
    private String descricaoUnidade;

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GrupoProduto getGrupoProduto() {
        return grupoProduto;
    }

    public void setGrupoProduto(GrupoProduto grupoProduto) {
        this.grupoProduto = grupoProduto;
    }

    public boolean isServico() {
        return servico;
    }

    public void setServico(boolean servico) {
        this.servico = servico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(double qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(double estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public String getDescricaoUnidade() {
        return descricaoUnidade;
    }

    public void setDescricaoUnidade(String descricaoUnidade) {
        this.descricaoUnidade = descricaoUnidade;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.grupoProduto);
        hash = 97 * hash + (this.servico ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.descricao);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.qtdEstoque) ^ (Double.doubleToLongBits(this.qtdEstoque) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.precoVenda) ^ (Double.doubleToLongBits(this.precoVenda) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.precoCusto) ^ (Double.doubleToLongBits(this.precoCusto) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.estoqueMinimo) ^ (Double.doubleToLongBits(this.estoqueMinimo) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.descricaoUnidade);
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
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
//        if (!Objects.equals(this.grupoProduto, other.grupoProduto)) {
//            return false;
//        }
//        if (this.servico != other.servico) {
//            return false;
//        }
//        if (!Objects.equals(this.descricao, other.descricao)) {
//            return false;
//        }
//        if (Double.doubleToLongBits(this.qtdEstoque) != Double.doubleToLongBits(other.qtdEstoque)) {
//            return false;
//        }
//        if (Double.doubleToLongBits(this.precoVenda) != Double.doubleToLongBits(other.precoVenda)) {
//            return false;
//        }
//        if (Double.doubleToLongBits(this.precoCusto) != Double.doubleToLongBits(other.precoCusto)) {
//            return false;
//        }
//        if (Double.doubleToLongBits(this.estoqueMinimo) != Double.doubleToLongBits(other.estoqueMinimo)) {
//            return false;
//        }
//        if (!Objects.equals(this.descricaoUnidade, other.descricaoUnidade)) {
//            return false;
//        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", grupoProduto=" + grupoProduto + ", servico=" + servico + ", descricao=" + descricao + ", qtdEstoque=" + qtdEstoque + ", precoVenda=" + precoVenda + ", precoCusto=" + precoCusto + ", estoqueMinimo=" + estoqueMinimo + ", descricaoUnidade=" + descricaoUnidade + '}';
    }

    @Override
    public int compareTo(Produto o) {
        return descricao.compareTo(o.descricao);
    }
    
    public String getTipo(){
        if(servico){
            return "Serviço";
        } else {
            return "Produto";
        }
    }
          
}
