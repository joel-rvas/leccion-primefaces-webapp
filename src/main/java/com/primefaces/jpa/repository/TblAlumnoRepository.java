package com.primefaces.jpa.repository;

import com.primefaces.jpa.model.TblAlumno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TblAlumnoRepository extends JpaRepository<TblAlumno, String> {

    List<TblAlumno> findByDniAndIndEstado(String dni, int indEstado);

    List<TblAlumno> findByIndEstado(int indEstado);

}