/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import entidades.EntidadPrueba;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import sessionBeans.EntidadPruebaSF;
import sessionBeans.EntidadPruebaSL;

/**
 *
 * @author User
 */
@ManagedBean
@SessionScoped
public class CapturasMB implements Serializable {

    private EntidadPrueba entidadPrueba;
    private String usuario;

    @EJB
    private EntidadPruebaSF entidadPruebaSF;

    @EJB
    private EntidadPruebaSL entidadPruebaSL;

    /**
     * Creates a new instance of CapturasMB
     */
    public CapturasMB() {
        entidadPrueba = new EntidadPrueba();
    }

    public EntidadPrueba getEntidadPrueba() {
        return entidadPrueba;
    }

    public void setEntidadPrueba(EntidadPrueba entidadPrueba) {
        this.entidadPrueba = entidadPrueba;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public EntidadPruebaSF getEntidadPruebaSF() {
        return entidadPruebaSF;
    }

    public void setEntidadPruebaSF(EntidadPruebaSF entidadPruebaSF) {
        this.entidadPruebaSF = entidadPruebaSF;
    }

    public EntidadPruebaSL getEntidadPruebaSL() {
        return entidadPruebaSL;
    }

    public void setEntidadPruebaSL(EntidadPruebaSL entidadPruebaSL) {
        this.entidadPruebaSL = entidadPruebaSL;
    }

    public void buscarRegistro() {
        Integer s = entidadPrueba.getP04id();
        EntidadPrueba m = entidadPruebaSF.obtenerEntidadPorId(s);
        if (m != null) {
            entidadPrueba.setP01texto(m.getP01texto());
            entidadPrueba.setP02numeroReal(m.getP02numeroReal());
            entidadPrueba.setP03categoria(m.getP03categoria());
            entidadPrueba.setP05fechaDeCaptura(m.getP05fechaDeCaptura());
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_WARN,
                    "Error, no se encuentra la entidad.",
                    null));
        }
    }

    public void validarFolio(Integer id) {
        EntidadPrueba rm = entidadPruebaSF.obtenerEntidadPorId(id);
        if (rm != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "Error, ya existe una entidad con el mismo folio.",
                    null));
        }
    }

    public String guardarSeguimientoAdulto() {
  // seguimientoAdulto.setP068Adultoes5(AdultoesConvivientes);
        //seguimientoAdulto.setP148visitas(visitas);

       //entidadPrueba.setZ06capturista(usuario);
        entidadPrueba.setP05fechaDeCaptura(new Date());
        int resultado = entidadPruebaSL.guardaEntidad(entidadPrueba);

        if (resultado == entidadPruebaSL.ENTIDAD_EXISTENTE) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_WARN,
                    "Error, ya existe un registro con el mismo folio.",
                    null));
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_INFO, "Guardado con exito",
                    ""));
            reset();
        }
        return null;
    }

    public String reset() {
        entidadPrueba = new EntidadPrueba();
        return null;
    }
}
