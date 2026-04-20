package com.example.demo.Controller;

import com.example.demo.MODEL.Equipo;
import com.example.demo.Service.EquipoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
@Tag(name = "Equipos", description = "Operaciones para gestionar equipos")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    @GetMapping
    @Operation(summary = "Obtener todos los equipos")
    public List<Equipo> getAllEquipos() {
        return equipoService.getAllEquipos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un equipo por su ID")
    public ResponseEntity<Equipo> getEquipoById(@PathVariable int id) {
        return equipoService.getEquipoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo equipo")
    public Equipo createEquipo(@RequestBody Equipo equipo) {
        return equipoService.saveEquipo(equipo);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un equipo existente")
    public ResponseEntity<Equipo> updateEquipo(@PathVariable int id, @RequestBody Equipo equipoDetails) {
        return equipoService.getEquipoById(id)
                .map(equipo -> {
                    equipo.setNombre(equipoDetails.getNombre());
                    equipo.setCiudad(equipoDetails.getCiudad());
                    equipo.setFundacion(equipoDetails.getFundacion());
                    return ResponseEntity.ok(equipoService.saveEquipo(equipo));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un equipo por su ID")
    public ResponseEntity<Void> deleteEquipo(@PathVariable int id) {
        return equipoService.getEquipoById(id)
                .map(equipo -> {
                    equipoService.deleteEquipo(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para consulta nativa
    @GetMapping("/{idEquipo}/total-goles")
    @Operation(summary = "Obtener el número total de goles marcados por un equipo")
    public ResponseEntity<Integer> getTotalGolesByEquipo(@PathVariable int idEquipo) {
        Integer totalGoles = equipoService.getTotalGolesByEquipo(idEquipo);
        return ResponseEntity.ok(totalGoles != null ? totalGoles : 0);
    }
}
