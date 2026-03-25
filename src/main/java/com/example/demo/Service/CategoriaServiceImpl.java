package com.example.demo.Service;

import com.example.demo.MODEL.Categoria;
import com.example.demo.Repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria buscarCategoria(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con id: " + id));
    }

    @Override
    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria editarCategoria(Long id, Categoria categoria) {
        Categoria categoriaExistente = buscarCategoria(id);
        categoriaExistente.setNombre(categoria.getNombre());
        categoriaExistente.setDescripcion(categoria.getDescripcion());
        return categoriaRepository.save(categoriaExistente);
    }

    @Override
    public void eliminarCategoria(Long id) {
        buscarCategoria(id); // Verifica que existe antes de eliminar
        categoriaRepository.deleteById(id);
    }
}
