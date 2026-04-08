package com.example.demo.Service;

import com.example.demo.MODEL.Propietario;
import java.util.List;

public interface PropietarioService {
    List<Propietario> listar();
    Propietario guardar(Propietario propietario);
    Propietario buscarPorId(Long id);
    Propietario modificar(Long id, Propietario propietario);
    void eliminar(Long id);
}