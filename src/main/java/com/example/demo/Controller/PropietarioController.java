package com.example.demo.Controller;

import com.example.demo.MODEL.Propietario;
import com.example.demo.Service.PropietarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/propietarios")
public class PropietarioController {

    private final PropietarioService propietarioService;

    public PropietarioController(PropietarioService propietarioService) {
        this.propietarioService = propietarioService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Propietario>> listar() {
        return ResponseEntity.ok(propietarioService.listar());
    }

    @PostMapping("/guardar")
    public ResponseEntity<Propietario> guardar(@RequestBody Propietario propietario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(propietarioService.guardar(propietario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Propietario> buscarPorId(@PathVariable Long id) {
        Propietario propietario = propietarioService.buscarPorId(id);
        return propietario != null ? ResponseEntity.ok(propietario) : ResponseEntity.notFound().build();
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<Propietario> modificar(@PathVariable Long id, @RequestBody Propietario propietario) {
        Propietario actualizado = propietarioService.modificar(id, propietario);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        propietarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}