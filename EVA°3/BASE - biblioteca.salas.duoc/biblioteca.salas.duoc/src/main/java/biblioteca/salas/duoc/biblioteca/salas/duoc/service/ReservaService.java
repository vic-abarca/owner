package biblioteca.salas.duoc.biblioteca.salas.duoc.service;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Reserva;
import biblioteca.salas.duoc.biblioteca.salas.duoc.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository ReservaRepository();

    public List<Reserva> findAll() {
        return ReservaRepository.findAll();
    }

    public Reserva findById(Integer id) {
        return ReservaRepository.findById(id).orElse(null);
    }

    public Reserva save(Reserva reserva) {
        return ReservaRepository.save(reserva);
    }

    public void deleteById(Integer id) {
        ReservaRepository.deleteById(id);
    }
}