package com.primefaces.controller;

import com.primefaces.jpa.model.TblPersona;
import com.primefaces.services.IPersonaService;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class PersonaView implements Serializable {

    @Autowired
    IPersonaService personaService;

    List<TblPersona> personas;
    List<TblPersona> filteredPersonaLista;
    private TblPersona selectedPersona;

    @PostConstruct
    public void init() throws Exception {
        listarPersonas();
    }

    public String logOut() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login?faces-redirect=true";
    }

    public void listarPersonas() throws Exception {
        personas = personaService.listarPersona(); //
        this.selectedPersona = new TblPersona();
        this.filteredPersonaLista = new ArrayList<>();
    }

    public void deletePersona() throws Exception {
        this.personas.remove(this.selectedPersona);
        this.personaService.eliminarPersona(this.selectedPersona);
        listarPersonas();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sistema", "Persona eliminado"));
        PrimeFaces.current().ajax().update("form:messages", "form:dtPersona", "form:pnlPersona");
    }

    public void guardar() throws Exception {
        this.personaService.actualizarPersona(this.selectedPersona);
        listarPersonas();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sistema", "Persona actualizado"));
        PrimeFaces.current().ajax().update("form:messages", "form:dtPersona");
    }

    public void abriNuevo() {
        this.selectedPersona = new TblPersona();
    }

    public List<TblPersona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<TblPersona> personas) {
        this.personas = personas;
    }

    public TblPersona getSelectedPersona() {
        return selectedPersona;
    }

    public void setSelectedPersona(TblPersona selectedPersona) {
        this.selectedPersona = selectedPersona;
    }

    public List<TblPersona> getFilteredPersonaLista() {
        return filteredPersonaLista;
    }

    public void setFilteredPersonaLista(List<TblPersona> filteredPersonaLista) {
        this.filteredPersonaLista = filteredPersonaLista;
    }
}
