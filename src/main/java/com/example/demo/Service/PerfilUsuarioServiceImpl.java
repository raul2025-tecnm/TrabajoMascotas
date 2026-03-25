package com.example.demo.Service;

import com.example.demo.MODEL.PerfilUsuario;
import com.example.demo.Repository.PerfilUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilUsuarioServiceImpl implements PerfilUsuarioService {

    private final PerfilUsuarioRepository perfilUsuarioRepository;

    public PerfilUsuarioServiceImpl(PerfilUsuarioRepository perfilUsuarioRepository) {
        this.perfilUsuarioRepository = perfilUsuarioRepository;
    }

    @Override
    public List<PerfilUsuario> listar() {
        return perfilUsuarioRepository.findAll();
    }

    @Override
    public PerfilUsuario guardar(PerfilUsuario perfilUsuario) {
        return perfilUsuarioRepository.save(perfilUsuario);
    }

    @Override
    public PerfilUsuario buscarPorId(Long id) {
        return perfilUsuarioRepository.findById(id).orElse(null);
    }

    @Override
    public PerfilUsuario modificar(Long id, PerfilUsuario perfilUsuario) {
        return perfilUsuarioRepository.findById(id).map(existente -> {
            existente.setDocumento(perfilUsuario.getDocumento());
            existente.setTelefono(perfilUsuario.getTelefono());
            existente.setUsuario(perfilUsuario.getUsuario());
            return perfilUsuarioRepository.save(existente);
        }).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        perfilUsuarioRepository.deleteById(id);
    }
}