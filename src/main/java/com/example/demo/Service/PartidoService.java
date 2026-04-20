package com.example.demo.Service;

import com.example.demo.DTO.PartidoResultadoDTO;
import com.example.demo.MODEL.Partido;
import com.example.demo.Repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartidoService {

    @Autowired
    private PartidoRepository partidoRepository;

    public List<Partido> getAllPartidos() {
        return partidoRepository.findAll();
    }

    public Optional<Partido> getPartidoById(int id) {
        return partidoRepository.findById(id);
    }

    public Partido savePartido(Partido partido) {
        return partidoRepository.save(partido);
    }

    public void deletePartido(int id) {
        partidoRepository.deleteById(id);
    }

    // Método para consulta nativa
    public List<PartidoResultadoDTO> getResultadosDeTodosLosPartidos() {
        return partidoRepository.findResultadosDeTodosLosPartidos();
    }
}
