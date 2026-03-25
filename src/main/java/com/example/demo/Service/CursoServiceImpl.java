package com.example.demo.Service;

import com.example.demo.MODEL.Curso;
import com.example.demo.Repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public List<Curso> listar() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso guardar(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Curso buscarPorId(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    @Override
    public Curso modificar(Long id, Curso curso) {
        return cursoRepository.findById(id).map(existente -> {
            existente.setNombre(curso.getNombre());
            existente.setCreditos(curso.getCreditos());
            return cursoRepository.save(existente);
        }).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        cursoRepository.deleteById(id);
    }
}