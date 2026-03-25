package com.example.demo.Service;

import com.example.demo.MODEL.Categoria;
import java.util.List;

public interface CategoriaService {
    List<Categoria> listarCategorias();
    Categoria buscarCategoria(Long id);
    Categoria guardarCategoria(Categoria categoria);
    Categoria editarCategoria(Long id, Categoria categoria);
    void eliminarCategoria(Long id);
}
