package com.example.demo.Controller;

import com.example.demo.MODEL.Entrenador;
import com.example.demo.Service.EntrenadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrenadores")
@Tag(name = "Entrenadores", description = "Operaciones para gestionar entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;

    @GetMapping
    @Operation(summary = "Obtener todos los entrenadores")
    public List<Entrenador> getAllEntrenadores() {
        return entrenadorService.getAllEntrenadores();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un entrenador por su ID")
    public ResponseEntity<Entrenador> getEntrenadorById(@PathVariable int id) {
        return entrenadorService.getEntrenadorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo entrenador")
    public Entrenador createEntrenador(@RequestBody Entrenador entrenador) {
        return entrenadorService.saveEntrenador(entrenador);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un entrenador existente")
    public ResponseEntity<Entrenador> updateEntrenador(@PathVariable int id, @RequestBody Entrenador entrenadorDetails) {
        return entrenadorService.getEntrenadorById(id)
                .map(entrenador -> {
                    entrenador.setNombre(entrenadorDetails.getNombre());
                    entrenador.setEspecialidad(entrenadorDetails.getEspecialidad());
                    entrenador.setEquipo(entrenadorDetails.getEquipo());
                    return ResponseEntity.ok(entrenadorService.saveEntrenador(entrenador));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un entrenador por su ID")
    public ResponseEntity<Void> deleteEntrenador(@PathVariable int id) {
        return entrenadorService.getEntrenadorById(id)
                .map(entrenador -> {
                    entrenadorService.deleteEntrenador(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
