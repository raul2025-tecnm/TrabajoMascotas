package com.example.demo.Service;

import com.example.demo.MODEL.Usuario;
import com.example.demo.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        if (usuario.getPerfil() != null) {
            usuario.getPerfil().setUsuario(usuario);
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario modificar(Long id, Usuario usuario) {
        return usuarioRepository.findById(id).map(existente -> {
            existente.setNombre(usuario.getNombre());
            existente.setCorre(usuario.getCorre());
            if (usuario.getPerfil() != null) {
                usuario.getPerfil().setUsuario(existente);
                existente.setPerfil(usuario.getPerfil());
            }
            return usuarioRepository.save(existente);
        }).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }
}