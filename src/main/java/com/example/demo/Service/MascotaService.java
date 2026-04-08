package com.example.demo.Service;

import com.example.demo.MODEL.Mascota;
import java.util.List;

public interface MascotaService {
    List<Mascota> listarMascotas();
    Mascota buscarMascota(Long id);
    Mascota guardarMascota(Mascota mascota);
    Mascota editarMascota(Long id, Mascota mascota);
    void eliminarMascota(Long id);
}