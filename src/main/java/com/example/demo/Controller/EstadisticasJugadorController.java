package com.example.demo.Controller;

import com.example.demo.MODEL.EstadisticasJugador;
import com.example.demo.Service.EstadisticasJugadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estadisticas")
@Tag(name = "Estadísticas de Jugador", description = "Operaciones para gestionar estadísticas de jugadores")
public class EstadisticasJugadorController {

    @Autowired
    private EstadisticasJugadorService estadisticasJugadorService;

    @GetMapping
    @Operation(summary = "Obtener todas las estadísticas")
    public List<EstadisticasJugador> getAllEstadisticas() {
        return estadisticasJugadorService.getAllEstadisticas();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una estadística por su ID")
    public ResponseEntity<EstadisticasJugador> getEstadisticaById(@PathVariable int id) {
        return estadisticasJugadorService.getEstadisticaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear una nueva estadística")
    public EstadisticasJugador createEstadistica(@RequestBody EstadisticasJugador estadistica) {
        return estadisticasJugadorService.saveEstadistica(estadistica);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una estadística existente")
    public ResponseEntity<EstadisticasJugador> updateEstadistica(@PathVariable int id, @RequestBody EstadisticasJugador estadisticaDetails) {
        return estadisticasJugadorService.getEstadisticaById(id)
                .map(estadistica -> {
                    estadistica.setJugador(estadisticaDetails.getJugador());
                    estadistica.setPartido(estadisticaDetails.getPartido());
                    estadistica.setMinutos_jugados(estadisticaDetails.getMinutos_jugados());
                    estadistica.setGoles(estadisticaDetails.getGoles());
                    estadistica.setAsistencias(estadisticaDetails.getAsistencias());
                    estadistica.setTarjetas_amarillas(estadisticaDetails.getTarjetas_amarillas());
                    estadistica.setTarjetas_rojas(estadisticaDetails.getTarjetas_rojas());
                    return ResponseEntity.ok(estadisticasJugadorService.saveEstadistica(estadistica));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una estadística por su ID")
    public ResponseEntity<Void> deleteEstadistica(@PathVariable int id) {
        return estadisticasJugadorService.getEstadisticaById(id)
                .map(estadistica -> {
                    estadisticasJugadorService.deleteEstadistica(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
