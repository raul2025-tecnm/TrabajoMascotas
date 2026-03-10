package com.example.demo.Controller;

import com.example.demo.Model.Estudiante;
import com.example.demo.Service.EstudianteService;
import com.example.demo.Service.EstudianteserviceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EstudianteController {

    private final EstudianteserviceImp estudianteserviceImp;
    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteserviceImp estudianteserviceImp, EstudianteService estudianteService) {
        this.estudianteserviceImp = estudianteserviceImp;
        this.estudianteService = estudianteService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Estudiante>> listar() {
        List<Estudiante> estudiantes = estudianteserviceImp.listar();
        return ResponseEntity.ok(estudiantes);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Estudiante> guardar(@RequestBody Estudiante estudiante) {
        Estudiante estudianteGuardar= estudianteService.guardar(estudiante);
        return ResponseEntity.status(201).body(estudianteGuardar);
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
        return ResponseEntity.ok(actualizado);
    }
    @PutMapping("/actualizar/{codigo}")
    public ResponseEntity<Estudiante> actualizar(
            @PathVariable Long codigo,
            @RequestBody Estudiante estudiante) {

        Estudiante actualizado = estudianteserviceImp.actualizar(codigo, estudiante);
        return ResponseEntity.ok(actualizado);
    }


}