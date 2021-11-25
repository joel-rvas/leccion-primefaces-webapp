package com.primefaces.services;

import com.primefaces.jpa.model.TblPersona;

import java.util.List;

public interface IPersonaService {

    List<TblPersona> listarPersona() throws Exception;
    void eliminarPersona(TblPersona persona);

    void actualizarPersona(TblPersona persona);
}
