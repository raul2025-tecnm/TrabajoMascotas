package com.example.demo.Service;

import com.example.demo.MODEL.Libro;
import java.util.List;

public interface LibroService {
    List<Libro> listar();
    Libro guardar(Libro libro);
    Libro buscarPorId(Long id);
    Libro modificar(Long id, Libro libro);
    void eliminar(Long id);
}