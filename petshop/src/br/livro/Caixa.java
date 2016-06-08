
package br.livro;

import br.usuario.Usuario;
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
public class Caixa implements Serializable, Comparable<Caixa>{
    
    @Id
    @GeneratedValue
    private Integer id;
    
    private String nrCaixa;
    
    @Temporal(TemporalType.DATE)
    private Date dataAbriu;
    
    @Temporal(TemporalType.DATE)
    private Date dataFechou;
    
    @Temporal(TemporalType.TIME)
    private Date horaAbriu;
    
    @Temporal(TemporalType.TIME)
    private Date horaFechou;
    
    private double valorFicaCaixa;
    
    private double retirada;
    
    @ManyToOne
    private Usuario user;
    
    private boolean aberto;
    
    public Date getHoraAbriu() {
        return horaAbriu;
    }

    public void setHoraAbriu(Date horaAbriu) {
        this.horaAbriu = horaAbriu;
    }

    public String getNrCaixa() {
        return nrCaixa;
    }

    public void setNrCaixa(String nrCaixa) {
        this.nrCaixa = nrCaixa;
    }
    
    public Date getHoraFechou() {
        return horaFechou;
    }

    public void setHoraFechou(Date horaFechou) {
        this.horaFechou = horaFechou;
    }
    
    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }
    
    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getRetirada() {
        return retirada;
    }

    public void setRetirada(double retirada) {
        this.retirada = retirada;
    }

    public Date getDataAbriu() {
        return dataAbriu;
    }

    public void setDataAbriu(Date dataAbriu) {
        this.dataAbriu = dataAbriu;
    }

    public Date getDataFechou() {
        return dataFechou;
    }

    public void setDataFechou(Date dataFechou) {
        this.dataFechou = dataFechou;
    }

    public double getValorFicaCaixa() {
        return valorFicaCaixa;
    }

    public void setValorFicaCaixa(double valorFicaCaixa) {
        this.valorFicaCaixa = valorFicaCaixa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.nrCaixa);
        hash = 67 * hash + Objects.hashCode(this.dataAbriu);
        hash = 67 * hash + Objects.hashCode(this.dataFechou);
        hash = 67 * hash + Objects.hashCode(this.horaAbriu);
        hash = 67 * hash + Objects.hashCode(this.horaFechou);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.valorFicaCaixa) ^ (Double.doubleToLongBits(this.valorFicaCaixa) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.retirada) ^ (Double.doubleToLongBits(this.retirada) >>> 32));
        hash = 67 * hash + Objects.hashCode(this.user);
        hash = 67 * hash + (this.aberto ? 1 : 0);
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
        final Caixa other = (Caixa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nrCaixa, other.nrCaixa)) {
            return false;
        }
        if (!Objects.equals(this.dataAbriu, other.dataAbriu)) {
            return false;
        }
        if (!Objects.equals(this.dataFechou, other.dataFechou)) {
            return false;
        }
        if (!Objects.equals(this.horaAbriu, other.horaAbriu)) {
            return false;
        }
        if (!Objects.equals(this.horaFechou, other.horaFechou)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorFicaCaixa) != Double.doubleToLongBits(other.valorFicaCaixa)) {
            return false;
        }
        if (Double.doubleToLongBits(this.retirada) != Double.doubleToLongBits(other.retirada)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (this.aberto != other.aberto) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Caixa o) {
        return o.id.compareTo(id);
    }
    
    
}
