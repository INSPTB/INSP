/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author User
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "EntidadPrueba.findAll", query = "Select p from EntidadPrueba p "),
    @NamedQuery(name = "EntidadPrueba.findById",
            query
            = "Select p from EntidadPrueba p where p.id=:i")
})
public class EntidadPrueba implements Serializable {

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date p05fechaDeCaptura;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private Integer p04id;
    
    private String p01texto;
    private Double p02numeroReal;
    private Integer p03categoria;
   

    public Date getP05fechaDeCaptura() {
        return p05fechaDeCaptura;
    }

    public void setP05fechaDeCaptura(Date p05fechaDeCaptura) {
        this.p05fechaDeCaptura = p05fechaDeCaptura;
    }

    public String getP01texto() {
        return p01texto;
    }

    public void setP01texto(String p01texto) {
        this.p01texto = p01texto;
    }

    public Double getP02numeroReal() {
        return p02numeroReal;
    }

    public void setP02numeroReal(Double p02numeroReal) {
        this.p02numeroReal = p02numeroReal;
    }

    public Integer getP03categoria() {
        return p03categoria;
    }

    public void setP03categoria(Integer p03categoria) {
        this.p03categoria = p03categoria;
    }

    public Integer getP04id() {
        return p04id;
    }

    public void setP04id(Integer p04id) {
        this.p04id = p04id;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (p04id != null ? p04id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntidadPrueba)) {
            return false;
        }
        EntidadPrueba other = (EntidadPrueba) object;
        if ((this.p04id == null && other.p04id != null) || (this.p04id != null && !this.p04id.equals(other.p04id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.EntidadPrueba[ id=" + p04id + " ]";
    }

}
