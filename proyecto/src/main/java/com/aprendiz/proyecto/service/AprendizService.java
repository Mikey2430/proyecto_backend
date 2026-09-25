package com.aprendiz.proyecto.service;

import com.aprendiz.proyecto.model.AprendizEntity;
import com.aprendiz.proyecto.repository.AprendizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AprendizService {
    @Autowired
    private AprendizRepository aprendizRepository;

    public void crearAprendiz(AprendizEntity aprendiz) {
        aprendizRepository.save(aprendiz);
    }

    public List<AprendizEntity> obtenerAprendices() {
        return aprendizRepository.findAll();
    }

    public boolean eliminarAprendiz(Long id) {
        if (!aprendizRepository.existsById(id)) {
            return false;
        }
        aprendizRepository.deleteById(id);
        return true;
    }

    public AprendizEntity buscarAprendiz(Long id) {
        return aprendizRepository.findById(id).orElse(null);
    }

    public AprendizEntity actualizarAprendiz(Long id, AprendizEntity datos) {
        AprendizEntity actual = aprendizRepository.findById(id).orElse(null);
        if (actual == null) {
            return null;
        }
        actual.setPrimerNombre(datos.getPrimerNombre());
        actual.setSegundoNombre(datos.getSegundoNombre());
        actual.setPrimerApellido(datos.getPrimerApellido());
        actual.setSegundoApellido(datos.getSegundoApellido());
        actual.setCorreo(datos.getCorreo());
        actual.setCelular(datos.getCelular());
        actual.setDireccion(datos.getDireccion());
        actual.setCedula(datos.getCedula());
        actual.setTipoDePrograma(datos.getTipoDePrograma());
        actual.setPrograma(datos.getPrograma());
        actual.setFicha(datos.getFicha());
        actual.setRegional(datos.getRegional());
        return aprendizRepository.save(actual);
    }
}
