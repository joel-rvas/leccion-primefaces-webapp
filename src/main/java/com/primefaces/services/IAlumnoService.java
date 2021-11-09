package com.primefaces.services;

import com.primefaces.jpa.model.TblAlumno;

import java.util.List;

public interface IAlumnoService {

    List<TblAlumno> listarAlumnos() throws Exception;
    void eliminarAlumno(TblAlumno alumno);

}
