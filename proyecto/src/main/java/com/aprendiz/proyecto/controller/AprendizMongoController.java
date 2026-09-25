package com.aprendiz.proyecto.controller;

import com.aprendiz.proyecto.model.AprendizDocument;
import com.aprendiz.proyecto.service.AprendizMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/aprendiz/mongo")
@CrossOrigin(origins = "http://localhost:5173")

public class AprendizMongoController {
    @Autowired
    private AprendizMongoService aprendizMongoService;

    @PostMapping
    public ResponseEntity<AprendizDocument> crearAprendiz(@RequestBody AprendizDocument aprendiz){
        aprendizMongoService.crearAprendiz(aprendiz);
        return ResponseEntity.status(HttpStatus.CREATED).body(aprendiz);
    }

    @GetMapping
    public List<AprendizDocument> obtenerAprendices(){
        return aprendizMongoService.obtenerAprendices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AprendizDocument> buscarAprendiz(@PathVariable String id){
        AprendizDocument encontrado = aprendizMongoService.buscarAprendiz(id);
        if (encontrado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(encontrado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AprendizDocument> actualizarAprendiz(@PathVariable String id, @RequestBody AprendizDocument aprendiz){
        AprendizDocument actualizado = aprendizMongoService.actualizarAprendiz(id, aprendiz);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAprendiz(@PathVariable String id) {
        boolean eliminado = aprendizMongoService.eliminarAprendiz(id);
        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
