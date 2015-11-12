
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Sandra
 */
@ManagedBean
@RequestScoped
public class LoginMB implements Serializable {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String logIn() {

        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {

            request.login(username, password);
        } catch (ServletException e) {

            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Inicio de sesion fallido", "Nombre de usuario o contraseña incorrecta"));
            username="";
            return "login";
        }
        return "index";
    }

    public String logOut() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            request.logout();
            
            System.out.println("LogOut");
            return "login";
        } catch (ServletException e) {
            context.addMessage(null, new FacesMessage("Fallo cierre de sesion"));
            System.out.println("LogOut2");
            return null;
        }

    }

    /**
     * Creates a new instance of LoginBean
     */
    public LoginMB() {
        
    }

}
