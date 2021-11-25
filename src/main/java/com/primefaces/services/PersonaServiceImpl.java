package com.primefaces.services;

import com.primefaces.jpa.model.TblPersona;
import com.primefaces.jpa.repository.TblPersonaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService {

    private static final Logger logger = LoggerFactory.getLogger(PersonaServiceImpl.class);

    @Autowired
    TblPersonaRepository alumnoRepository;

    @Override
    public List<TblPersona> listarPersona() throws Exception {
        logger.info("call : listarPersona");
        return alumnoRepository.findAll();
    }

    @Override
    public void eliminarPersona(TblPersona persona) {
        logger.info("call : eliminarPersona");
        alumnoRepository.delete(persona);
    }

    @Override
    public void actualizarPersona(TblPersona persona){
        logger.info("call : actualizarPersona");
        alumnoRepository.save(persona);
    }
}
