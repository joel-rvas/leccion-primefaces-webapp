package com.primefaces;

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
import java.util.List;

@Named
@ViewScoped
public class AlumnoView implements Serializable {

    private String dni;
    private String nombre;
    private String apelledio;
    private String celular;

    @Autowired
    IAlumnoService alumnoService;

    List<TblAlumno> alumnos;

    List<TblAlumno> filteredAlumnoLista;
    private TblAlumno selectedAlumno;

    @PostConstruct
    public void init() throws Exception {
        listarAlumnos();
    }

    public void listarAlumnos() throws Exception {
        alumnos = alumnoService.listarAlumnos();
    }

    public void deleteAlumno() throws Exception {
        this.alumnos.remove(this.selectedAlumno);
        this.alumnoService.eliminarAlumno(this.selectedAlumno);
        listarAlumnos();
        this.selectedAlumno = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sistema", "Alumno eliminado"));
        PrimeFaces.current().ajax().update("form:messages", "form:dtAlumno");
    }

    public void guardar() throws Exception {
        this.alumnoService.actualizarAlumno(this.selectedAlumno);
        this.selectedAlumno = null;
        listarAlumnos();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sistema", "Alumno actualizado"));
        PrimeFaces.current().ajax().update("form:messages", "form:dtAlumno");
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApelledio() {
        return apelledio;
    }

    public void setApelledio(String apelledio) {
        this.apelledio = apelledio;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
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
