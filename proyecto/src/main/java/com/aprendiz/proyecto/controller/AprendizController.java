package com.aprendiz.proyecto.controller;

import com.aprendiz.proyecto.model.AprendizEntity;
import com.aprendiz.proyecto.service.AprendizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/aprendiz")
@CrossOrigin(origins = "http://localhost:5173")

public class AprendizController {
    @Autowired
    private AprendizService aprendizService;

    @PostMapping
    public ResponseEntity<AprendizEntity> crearAprendiz(@RequestBody AprendizEntity aprendiz){
        aprendizService.crearAprendiz(aprendiz);
        return ResponseEntity.status(HttpStatus.CREATED).body(aprendiz);
    }

    @GetMapping
    public List<AprendizEntity> obtenerAprendices(){
        return aprendizService.obtenerAprendices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AprendizEntity> buscarAprendiz(@PathVariable Long id){
        AprendizEntity encontrado = aprendizService.buscarAprendiz(id);
        if (encontrado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(encontrado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AprendizEntity> actualizarAprendiz(@PathVariable Long id, @RequestBody AprendizEntity aprendiz){
        AprendizEntity actualizado = aprendizService.actualizarAprendiz(id, aprendiz);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAprendiz(@PathVariable Long id) {
        boolean eliminado = aprendizService.eliminarAprendiz(id);
        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
