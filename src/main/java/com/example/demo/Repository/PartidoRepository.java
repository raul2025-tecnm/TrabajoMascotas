package com.example.demo.Repository;

import com.example.demo.DTO.PartidoResultadoDTO;
import com.example.demo.MODEL.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Integer> {

    /**
     * Obtiene los resultados de todos los partidos, incluyendo los nombres de los equipos.
     * @return Lista de resultados de partidos.
     */
    @Query(value = "SELECT new com.example.demo.DTO.PartidoResultadoDTO(" +
                   "el.nombre, ev.nombre, p.goles_local, p.goles_visita, p.fecha, p.estadio) " +
                   "FROM Partido p " +
                   "JOIN p.equipoLocal el " +
                   "JOIN p.equipoVisitante ev")
    List<PartidoResultadoDTO> findResultadosDeTodosLosPartidos();
}
