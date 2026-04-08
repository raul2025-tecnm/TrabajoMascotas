package com.example.demo.Service;

import com.example.demo.MODEL.Propietario;
import com.example.demo.Repository.PropietarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropietarioServiceImpl implements PropietarioService {

    private final PropietarioRepository propietarioRepository;

    public PropietarioServiceImpl(PropietarioRepository propietarioRepository) {
        this.propietarioRepository = propietarioRepository;
    }

    @Override
    public List<Propietario> listar() {
        return propietarioRepository.findAll();
    }

    @Override
    public Propietario guardar(Propietario propietario) {
        return propietarioRepository.save(propietario);
    }

    @Override
    public Propietario buscarPorId(Long id) {
        return propietarioRepository.findById(id).orElse(null);
    }

    @Override
    public Propietario modificar(Long id, Propietario propietario) {
        return propietarioRepository.findById(id).map(existente -> {
            existente.setNombre(propietario.getNombre());
            existente.setCorreo(propietario.getCorreo());
            existente.setTelefono(propietario.getTelefono());
            return propietarioRepository.save(existente);
        }).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        propietarioRepository.deleteById(id);
    }
}