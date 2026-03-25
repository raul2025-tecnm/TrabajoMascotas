package com.example.demo.Service;

import com.example.demo.MODEL.PerfilUsuario;
import java.util.List;

public interface PerfilUsuarioService {
    List<PerfilUsuario> listar();
    PerfilUsuario guardar(PerfilUsuario perfilUsuario);
    PerfilUsuario buscarPorId(Long id);
    PerfilUsuario modificar(Long id, PerfilUsuario perfilUsuario);
    void eliminar(Long id);
}