package com.example.demo.Service;

import com.example.demo.MODEL.Estudiante; // Corregido de Model a MODEL
import com.example.demo.Repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteserviceImp implements EstudianteService {
    private final EstudianteRepository estudianteRepository;

    public EstudianteserviceImp(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    public List<Estudiante> listar() {
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante guardar(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public void eliminar(Long codigo) {
        estudianteRepository.deleteById(codigo);
    }

    @Override
    public Estudiante modificar(Long codigo, Estudiante estudiante) {
        Optional<Estudiante> estudianteExistente = estudianteRepository.findById(codigo);
        if (estudianteExistente.isPresent()) {
            Estudiante estudianteActualizado = estudianteExistente.get();
            estudianteActualizado.setNombre(estudiante.getNombre());
            estudianteActualizado.setCorreo(estudiante.getCorreo());
            // estudianteActualizado.setCursos(estudiante.getCursos()); // Si deseas actualizar los cursos también
            return estudianteRepository.save(estudianteActualizado);
        }
        return null;
    }
}