package com.example.demo.Service;

import com.example.demo.Model.Estudiante;
import com.example.demo.Repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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


}
