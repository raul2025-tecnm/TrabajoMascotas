package com.example.demo.Controller;

import com.example.demo.MODEL.Estudiante; // CORREGIDO: MODEL en mayúsculas
import com.example.demo.Service.EstudianteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes") // Mejor convención REST
public class EstudianteController {

    // CORREGIDO: Solo inyectar la interfaz, no la implementación concreta
    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Estudiante>> listar() {
        List<Estudiante> estudiantes = estudianteService.listar();
        return ResponseEntity.ok(estudiantes);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Estudiante> guardar(@RequestBody Estudiante estudiante) {
        Estudiante estudianteGuardar = estudianteService.guardar(estudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(estudianteGuardar);
    }

    @DeleteMapping("/eliminar/{codigo}")
    public ResponseEntity<Void> eliminar(@PathVariable Long codigo) {
        estudianteService.eliminar(codigo);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/modificar/{codigo}")
    public ResponseEntity<Estudiante> modificar(
            @PathVariable Long codigo,
            @RequestBody Estudiante estudiante) {

        Estudiante actualizado = estudianteService.modificar(codigo, estudiante);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // CORREGIDO: Se eliminó el método duplicado "actualizar" que llamaba a un método inexistente.
}