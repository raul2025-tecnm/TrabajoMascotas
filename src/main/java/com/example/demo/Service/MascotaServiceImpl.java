package com.example.demo.Service;

import com.example.demo.MODEL.Mascota;
import com.example.demo.Repository.MascotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaServiceImpl implements MascotaService {

    private final MascotaRepository mascotaRepository;

    public MascotaServiceImpl(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    @Override
    public List<Mascota> listarMascotas() {
        return mascotaRepository.findAll();
    }

    @Override
    public Mascota buscarMascota(Long id) {
        return mascotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada con id: " + id));
    }

    @Override
    public Mascota guardarMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    @Override
    public Mascota editarMascota(Long id, Mascota mascota) {
        Mascota mascotaExistente = buscarMascota(id);
        mascotaExistente.setNombre(mascota.getNombre());
        mascotaExistente.setEspecie(mascota.getEspecie());
        mascotaExistente.setRaza(mascota.getRaza());
        mascotaExistente.setEdad(mascota.getEdad());
        return mascotaRepository.save(mascotaExistente);
    }

    @Override
    public void eliminarMascota(Long id) {
        buscarMascota(id); // Verifica que existe antes de eliminar
        mascotaRepository.deleteById(id);
    }
}