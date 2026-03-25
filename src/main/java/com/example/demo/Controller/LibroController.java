package com.example.demo.Controller;

import com.example.demo.MODEL.Libro;
import com.example.demo.Service.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Libro>> listar() {
        return ResponseEntity.ok(libroService.listar());
    }

    @PostMapping("/guardar")
    public ResponseEntity<Libro> guardar(@RequestBody Libro libro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(libroService.guardar(libro));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> buscarPorId(@PathVariable Long id) {
        Libro libro = libroService.buscarPorId(id);
        return libro != null ? ResponseEntity.ok(libro) : ResponseEntity.notFound().build();
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<Libro> modificar(@PathVariable Long id, @RequestBody Libro libro) {
        Libro actualizado = libroService.modificar(id, libro);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        libroService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}