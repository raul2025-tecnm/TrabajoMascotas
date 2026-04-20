package com.example.demo.Service;

import com.example.demo.MODEL.EstadisticasJugador;
import com.example.demo.Repository.EstadisticasJugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadisticasJugadorService {

    @Autowired
    private EstadisticasJugadorRepository estadisticasJugadorRepository;

    public List<EstadisticasJugador> getAllEstadisticas() {
        return estadisticasJugadorRepository.findAll();
    }

    public Optional<EstadisticasJugador> getEstadisticaById(int id) {
        return estadisticasJugadorRepository.findById(id);
    }

    public EstadisticasJugador saveEstadistica(EstadisticasJugador estadistica) {
        return estadisticasJugadorRepository.save(estadistica);
    }

    public void deleteEstadistica(int id) {
        estadisticasJugadorRepository.deleteById(id);
    }
}
