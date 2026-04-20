package com.example.demo.Controller;

import com.example.demo.MODEL.Jugador;
import com.example.demo.Service.JugadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
@Tag(name = "Jugadores", description = "Operaciones para gestionar jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping
    @Operation(summary = "Obtener todos los jugadores")
    public List<Jugador> getAllJugadores() {
        return jugadorService.getAllJugadores();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un jugador por su ID")
    public ResponseEntity<Jugador> getJugadorById(@PathVariable int id) {
        return jugadorService.getJugadorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo jugador")
    public Jugador createJugador(@RequestBody Jugador jugador) {
        return jugadorService.saveJugador(jugador);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un jugador existente")
    public ResponseEntity<Jugador> updateJugador(@PathVariable int id, @RequestBody Jugador jugadorDetails) {
        return jugadorService.getJugadorById(id)
                .map(jugador -> {
                    jugador.setNombre(jugadorDetails.getNombre());
                    jugador.setPosicion(jugadorDetails.getPosicion());
                    jugador.setDorsal(jugadorDetails.getDorsal());
                    jugador.setFecha_nac(jugadorDetails.getFecha_nac());
                    jugador.setNacionalidad(jugadorDetails.getNacionalidad());
                    jugador.setEquipo(jugadorDetails.getEquipo());
                    return ResponseEntity.ok(jugadorService.saveJugador(jugador));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un jugador por su ID")
    public ResponseEntity<Void> deleteJugador(@PathVariable int id) {
        return jugadorService.getJugadorById(id)
                .map(jugador -> {
                    jugadorService.deleteJugador(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoints para consultas nativas
    @GetMapping("/equipo/{idEquipo}")
    @Operation(summary = "Obtener todos los jugadores de un equipo específico")
    public List<Jugador> getJugadoresByEquipo(@PathVariable int idEquipo) {
        return jugadorService.getJugadoresByEquipo(idEquipo);
    }

    @GetMapping("/goles-mayores-a/{totalGoles}")
    @Operation(summary = "Obtener jugadores que han marcado más de X goles")
    public List<Jugador> getJugadoresConMasDeXGoles(@PathVariable int totalGoles) {
        return jugadorService.getJugadoresConMasDeXGoles(totalGoles);
    }
}
