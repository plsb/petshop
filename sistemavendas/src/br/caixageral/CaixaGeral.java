
package br.caixageral;

import br.contaspagar.ContasPagar;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CaixaGeral implements Comparable<CaixaGeral>{
    
    @Id
    @GeneratedValue
    private Integer id;
    
    private String descricao;
    
    private double valorEntrada;
    
    private double valorSaida;
    
    @Temporal(TemporalType.DATE)
    private Date data;
    
    @ManyToOne
    private ContasPagar contaPagar;

    public ContasPagar getContaPagar() {
        return contaPagar;
    }

    public void setContaPagar(ContasPagar contaPagar) {
        this.contaPagar = contaPagar;
    }
        
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
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
        final CaixaGeral other = (CaixaGeral) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CaixaGeral{" + "id=" + id + ", descricao=" + descricao + ", valorEntrada=" + valorEntrada + ", valorSaida=" + valorSaida + ", data=" + data + '}';
    }

    @Override
    public int compareTo(CaixaGeral o) {
        return id.compareTo(o.id);
    }
    
}
