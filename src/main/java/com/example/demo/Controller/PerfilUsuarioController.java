package com.example.demo.Controller;

import com.example.demo.MODEL.PerfilUsuario;
import com.example.demo.Service.PerfilUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/perfiles")
public class PerfilUsuarioController {

    private final PerfilUsuarioService perfilUsuarioService;

    public PerfilUsuarioController(PerfilUsuarioService perfilUsuarioService) {
        this.perfilUsuarioService = perfilUsuarioService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<PerfilUsuario>> listar() {
        return ResponseEntity.ok(perfilUsuarioService.listar());
    }

    @PostMapping("/guardar")
    public ResponseEntity<PerfilUsuario> guardar(@RequestBody PerfilUsuario perfilUsuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(perfilUsuarioService.guardar(perfilUsuario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerfilUsuario> buscarPorId(@PathVariable Long id) {
        PerfilUsuario perfilUsuario = perfilUsuarioService.buscarPorId(id);
        return perfilUsuario != null ? ResponseEntity.ok(perfilUsuario) : ResponseEntity.notFound().build();
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<PerfilUsuario> modificar(@PathVariable Long id, @RequestBody PerfilUsuario perfilUsuario) {
        PerfilUsuario actualizado = perfilUsuarioService.modificar(id, perfilUsuario);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        perfilUsuarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}