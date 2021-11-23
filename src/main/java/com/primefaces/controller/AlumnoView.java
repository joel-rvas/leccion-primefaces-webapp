package com.primefaces.controller;

import com.primefaces.jpa.model.TblAlumno;
import com.primefaces.services.IAlumnoService;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class AlumnoView implements Serializable {

    @Autowired
    IAlumnoService alumnoService;

    List<TblAlumno> alumnos;
    List<TblAlumno> filteredAlumnoLista;
    private TblAlumno selectedAlumno;

    @PostConstruct
    public void init() throws Exception {
        listarAlumnos();
    }

    public String logOut() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login";
    }

    public void listarAlumnos() throws Exception {
        alumnos = alumnoService.listarAlumnos();
        this.selectedAlumno = new TblAlumno();
        this.filteredAlumnoLista = new ArrayList<>();
    }

    public void deleteAlumno() throws Exception {
        this.alumnos.remove(this.selectedAlumno);
        this.alumnoService.eliminarAlumno(this.selectedAlumno);
        listarAlumnos();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sistema", "Alumno eliminado"));
        PrimeFaces.current().ajax().update("form:messages", "form:dtAlumno", "form:pnlAlumno");
    }

    public void guardar() throws Exception {
        this.selectedAlumno.setIndEstado(1);
        this.alumnoService.actualizarAlumno(this.selectedAlumno);
        listarAlumnos();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sistema", "Alumno actualizado"));
        PrimeFaces.current().ajax().update("form:messages", "form:dtAlumno");
    }

    public void abriNuevo() {
        this.selectedAlumno = new TblAlumno();
    }

    public List<TblAlumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<TblAlumno> alumnos) {
        this.alumnos = alumnos;
    }

    public TblAlumno getSelectedAlumno() {
        return selectedAlumno;
    }

    public void setSelectedAlumno(TblAlumno selectedAlumno) {
        this.selectedAlumno = selectedAlumno;
    }

    public List<TblAlumno> getFilteredAlumnoLista() {
        return filteredAlumnoLista;
    }

    public void setFilteredAlumnoLista(List<TblAlumno> filteredAlumnoLista) {
        this.filteredAlumnoLista = filteredAlumnoLista;
    }
}
