package com.example.demo.Repository;

import com.example.demo.MODEL.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer> {

    /**
     * Obtiene todos los jugadores de un equipo específico.
     * @param idEquipo ID del equipo.
     * @return Lista de jugadores.
     */
    @Query(value = "SELECT * FROM jugador WHERE id_equipo = :idEquipo", nativeQuery = true)
    List<Jugador> findJugadoresByEquipo(@Param("idEquipo") int idEquipo);

    /**
     * Obtiene los jugadores que han marcado más de un número específico de goles en total.
     * @param totalGoles El número de goles a superar.
     * @return Lista de jugadores.
     */
    @Query(value = "SELECT j.* FROM jugador j " +
                   "JOIN (SELECT id_jugador, SUM(goles) as total_goles FROM estadisticas_jugador GROUP BY id_jugador) as stats " +
                   "ON j.id_jugador = stats.id_jugador " +
                   "WHERE stats.total_goles > :totalGoles", nativeQuery = true)
    List<Jugador> findJugadoresConMasDeXGoles(@Param("totalGoles") int totalGoles);
}
