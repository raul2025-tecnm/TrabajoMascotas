package com.example.demo.Service;

import com.example.demo.MODEL.Estudiante; // Corregido de Model a MODEL
import java.util.List;

public interface EstudianteService {
    //listar estudiantes
    List<Estudiante> listar();
    //guardar estudiantes
    Estudiante guardar(Estudiante estudiante);
    //eliminar estudiante
    void eliminar(Long codigo);
    // modificar estudiante
    Estudiante modificar(Long codigo, Estudiante estudiante);
}