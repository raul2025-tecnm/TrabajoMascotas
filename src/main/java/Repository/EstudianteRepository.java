package com.example.demo.Repository;

import com.example.demo.Model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EstudianteRepository extends JpaRepository<Estudiante,Long>{

}