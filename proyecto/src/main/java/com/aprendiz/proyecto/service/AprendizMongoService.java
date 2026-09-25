package com.aprendiz.proyecto.service;

import com.aprendiz.proyecto.model.AprendizDocument;
import com.aprendiz.proyecto.repository.AprendizMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AprendizMongoService {
    @Autowired
    private AprendizMongoRepository aprendizMongoRepository;

    public void crearAprendiz(AprendizDocument aprendiz) {
        aprendizMongoRepository.save(aprendiz);
    }

    public List<AprendizDocument> obtenerAprendices() {
        return aprendizMongoRepository.findAll();
    }

    public boolean eliminarAprendiz(String id) {
        if (!aprendizMongoRepository.existsById(id)) {
            return false;
        }
        aprendizMongoRepository.deleteById(id);
        return true;
    }

    public AprendizDocument buscarAprendiz(String id) {
        return aprendizMongoRepository.findById(id).orElse(null);
    }

    public AprendizDocument actualizarAprendiz(String id, AprendizDocument datos) {
        AprendizDocument actual = aprendizMongoRepository.findById(id).orElse(null);
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
        return aprendizMongoRepository.save(actual);
    }
}
