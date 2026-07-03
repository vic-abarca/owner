package biblioteca.salas.duoc.biblioteca.salas.duoc.service;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Sala;
import biblioteca.salas.duoc.biblioteca.salas.duoc.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {
    @Autowired
    private SalaRepository SalaRepository();

    public List<Sala> findAll() {
        return SalaRepository.findAll();
    }

    public Sala findById(Integer id) {
        return SalaRepository.findById(id).orElse(null);
    }

    public Sala save(Sala sala) {
        return SalaRepository.save(sala);
    }

    public void deleteById(Integer id) {
        SalaRepository.deleteById(id);
    }
}
