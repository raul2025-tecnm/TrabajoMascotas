package com.example.demo.Service;

import com.example.demo.MODEL.Curso;
import java.util.List;

public interface CursoService {
    List<Curso> listar();
    Curso guardar(Curso curso);
    Curso buscarPorId(Long id);
    Curso modificar(Long id, Curso curso);
    void eliminar(Long id);
}