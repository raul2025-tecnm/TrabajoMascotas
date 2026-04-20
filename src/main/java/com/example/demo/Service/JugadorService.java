package com.example.demo.Service;

import com.example.demo.MODEL.Jugador;
import com.example.demo.Repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    public List<Jugador> getAllJugadores() {
        return jugadorRepository.findAll();
    }

    public Optional<Jugador> getJugadorById(int id) {
        return jugadorRepository.findById(id);
    }

    public Jugador saveJugador(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    public void deleteJugador(int id) {
        jugadorRepository.deleteById(id);
    }

    // Métodos para consultas nativas
    public List<Jugador> getJugadoresByEquipo(int idEquipo) {
        return jugadorRepository.findJugadoresByEquipo(idEquipo);
    }

    public List<Jugador> getJugadoresConMasDeXGoles(int totalGoles) {
        return jugadorRepository.findJugadoresConMasDeXGoles(totalGoles);
    }
}
