package com.example.demo.Service;

import com.example.demo.Model.Estudiante;
import java.util.List;
public interface EstudianteService {
    //listar estudiantes
    List<Estudiante>listar();
    //guardar estudiantes
    Estudiante guardar(Estudiante estudiante);
    //eliminar estudiante
    void eliminar(Long codigo);
    // modificar estudiante
    Estudiante modificar(Long codigo, Estudiante estudiante);


}