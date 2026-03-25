package com.example.demo.Service;

import com.example.demo.MODEL.Libro;
import com.example.demo.Repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;

    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public List<Libro> listar() {
        return libroRepository.findAll();
    }

    @Override
    public Libro guardar(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Libro buscarPorId(Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    @Override
    public Libro modificar(Long id, Libro libro) {
        return libroRepository.findById(id).map(existente -> {
            existente.setTitulo(libro.getTitulo());
            existente.setAutor(libro.getAutor());
            existente.setAnioPublicacion(libro.getAnioPublicacion());
            existente.setCategoria(libro.getCategoria());
            return libroRepository.save(existente);
        }).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        libroRepository.deleteById(id);
    }
}