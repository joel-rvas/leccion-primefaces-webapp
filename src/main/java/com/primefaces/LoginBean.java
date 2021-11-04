package com.primefaces;

import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginBean implements Serializable {

    private String coUsua;
    private String dePassUsua;
    private UIComponent component;

    public String login() {
        return "";
    }

    public void cancelar() {
       // RequestContext.getCurrentInstance().reset("form:panel");
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
