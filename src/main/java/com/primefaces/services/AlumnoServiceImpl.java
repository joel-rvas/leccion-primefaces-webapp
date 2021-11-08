package com.primefaces.services;

import com.primefaces.jpa.model.TblAlumno;
import com.primefaces.jpa.repository.TblAlumnoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServiceImpl implements IAlumnoService {

    private static final Logger logger = LoggerFactory.getLogger(AlumnoServiceImpl.class);

    @Autowired
    TblAlumnoRepository alumnoRepository;

    @Override
    public List<TblAlumno> listarAlumnos() throws Exception {
        logger.info("call : listarAlumnos");
        return alumnoRepository.findAll();

    }
}
