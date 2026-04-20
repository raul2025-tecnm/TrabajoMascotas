package com.example.demo.Repository;

import com.example.demo.MODEL.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Integer> {

    /**
     * Obtiene el número total de goles marcados por un equipo en todos sus partidos.
     * @param idEquipo ID del equipo.
     * @return El número total de goles.
     */
    @Query(value = "SELECT SUM(goles) FROM (" +
                   "    SELECT SUM(goles_local) as goles FROM partido WHERE equipo_local = :idEquipo" +
                   "    UNION ALL" +
                   "    SELECT SUM(goles_visita) as goles FROM partido WHERE equipo_visita = :idEquipo" +
                   ") as total_goles", nativeQuery = true)
    Integer findTotalGolesByEquipo(@Param("idEquipo") int idEquipo);
}
