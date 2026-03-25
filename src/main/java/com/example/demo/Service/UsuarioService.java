package com.example.demo.Service;

import com.example.demo.MODEL.Usuario;
import java.util.List;

public interface UsuarioService {
    List<Usuario> listar();
    Usuario guardar(Usuario usuario);
    Usuario buscarPorId(Long id);
    Usuario modificar(Long id, Usuario usuario);
    void eliminar(Long id);
}