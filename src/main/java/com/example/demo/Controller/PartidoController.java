package com.example.demo.Controller;

import com.example.demo.DTO.PartidoResultadoDTO;
import com.example.demo.MODEL.Partido;
import com.example.demo.Service.PartidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partidos")
@Tag(name = "Partidos", description = "Operaciones para gestionar partidos")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    @GetMapping
    @Operation(summary = "Obtener todos los partidos")
    public List<Partido> getAllPartidos() {
        return partidoService.getAllPartidos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un partido por su ID")
    public ResponseEntity<Partido> getPartidoById(@PathVariable int id) {
        return partidoService.getPartidoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo partido")
    public Partido createPartido(@RequestBody Partido partido) {
        return partidoService.savePartido(partido);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un partido existente")
    public ResponseEntity<Partido> updatePartido(@PathVariable int id, @RequestBody Partido partidoDetails) {
        return partidoService.getPartidoById(id)
                .map(partido -> {
                    partido.setFecha(partidoDetails.getFecha());
                    partido.setEstadio(partidoDetails.getEstadio());
                    partido.setEquipoLocal(partidoDetails.getEquipoLocal());
                    partido.setEquipoVisitante(partidoDetails.getEquipoVisitante());
                    partido.setGoles_local(partidoDetails.getGoles_local());
                    partido.setGoles_visita(partidoDetails.getGoles_visita());
                    return ResponseEntity.ok(partidoService.savePartido(partido));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un partido por su ID")
    public ResponseEntity<Void> deletePartido(@PathVariable int id) {
        return partidoService.getPartidoById(id)
                .map(partido -> {
                    partidoService.deletePartido(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para consulta nativa
    @GetMapping("/resultados")
    @Operation(summary = "Obtener los resultados de todos los partidos con nombres de equipos")
    public List<PartidoResultadoDTO> getResultadosDeTodosLosPartidos() {
        return partidoService.getResultadosDeTodosLosPartidos();
    }
}
