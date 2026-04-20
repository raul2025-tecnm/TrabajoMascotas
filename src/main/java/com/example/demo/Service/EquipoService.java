package com.example.demo.Service;

import com.example.demo.MODEL.Equipo;
import com.example.demo.Repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    public List<Equipo> getAllEquipos() {
        return equipoRepository.findAll();
    }

    public Optional<Equipo> getEquipoById(int id) {
        return equipoRepository.findById(id);
    }

    public Equipo saveEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public void deleteEquipo(int id) {
        equipoRepository.deleteById(id);
    }

    // Método para consulta nativa
    public Integer getTotalGolesByEquipo(int idEquipo) {
        return equipoRepository.findTotalGolesByEquipo(idEquipo);
    }
}
