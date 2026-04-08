package com.example.demo.Controller;

import com.example.demo.MODEL.Mascota;
import com.example.demo.Service.MascotaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

    private final MascotaService mascotaService;

    public MascotaController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    @GetMapping
    public ResponseEntity<List<Mascota>> listarMascotas() {
        return ResponseEntity.ok(mascotaService.listarMascotas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mascota> buscarMascota(@PathVariable Long id) {
        return ResponseEntity.ok(mascotaService.buscarMascota(id));
    }

    @PostMapping
    public ResponseEntity<Mascota> guardarMascota(@RequestBody Mascota mascota) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mascotaService.guardarMascota(mascota));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mascota> editarMascota(@PathVariable Long id, @RequestBody Mascota mascota) {
        return ResponseEntity.ok(mascotaService.editarMascota(id, mascota));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarMascota(@PathVariable Long id) {
        mascotaService.eliminarMascota(id);
        return ResponseEntity.ok("Mascota eliminada correctamente");
    }
}