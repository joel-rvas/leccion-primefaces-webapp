package com.primefaces;

import org.primefaces.PrimeFaces;

import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginBean implements Serializable {

    private String coUsua;
    private String dePassUsua;
    private UIComponent component;

    static final String usuario = "ADMIN";
    static final String clave = "123";

    public String login() {

        if (coUsua.equals(usuario) && clave.equals(dePassUsua)) {
            //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("AUTHENTICATED", "OK");
            //this.usuario = ((ClaTabSegUsuario)this.usuarioList.get(0));
            return "alumno";
        }

        return "";
    }

    public void cancelar() {
        //FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        this.coUsua = "";
        PrimeFaces.current().resetInputs("form:panel");
    }

    public String getCoUsua() {
        return coUsua;
    }

    public void setCoUsua(String coUsua) {
        this.coUsua = coUsua;
    }

    public String getDePassUsua() {
        return dePassUsua;
    }

    public void setDePassUsua(String dePassUsua) {
        this.dePassUsua = dePassUsua;
    }

    public UIComponent getComponent() {
        return component;
    }

    public void setComponent(UIComponent component) {
        this.component = component;
    }
}
