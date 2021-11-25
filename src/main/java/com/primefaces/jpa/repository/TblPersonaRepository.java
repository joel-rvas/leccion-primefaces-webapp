package com.primefaces.jpa.repository;

import com.primefaces.jpa.model.TblPersona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TblPersonaRepository extends JpaRepository<TblPersona, String> {

    List<TblPersona> findByDni(String dni);

}