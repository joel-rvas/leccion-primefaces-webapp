package com.primefaces;

import com.primefaces.jpa.model.TblAlumno;
import com.primefaces.services.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class AlumnoBean implements Serializable {

    private String dni;
    private String nombre;
    private String apelledio;
    private String celular;

    @Autowired
    IAlumnoService alumnoService;

    List<TblAlumno> alumnoLista;
    List<TblAlumno> filteredAlumnoLista;

    @PostConstruct
    public void init() throws Exception {
        listarAlumnos();
    }

    public void listarAlumnos() throws Exception {
        alumnoLista = alumnoService.listarAlumnos();
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

    public List<TblAlumno> getAlumnoLista() {
        return alumnoLista;
    }

    public void setAlumnoLista(List<TblAlumno> alumnoLista) {
        this.alumnoLista = alumnoLista;
    }

    public List<TblAlumno> getFilteredAlumnoLista() {
        return filteredAlumnoLista;
    }

    public void setFilteredAlumnoLista(List<TblAlumno> filteredAlumnoLista) {
        this.filteredAlumnoLista = filteredAlumnoLista;
    }
}
