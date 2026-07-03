package biblioteca.salas.duoc.biblioteca.salas.duoc.service;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.TipoSala;
import biblioteca.salas.duoc.biblioteca.salas.duoc.repository.TipoSalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoSalaService {
    @Autowired
    private TipoSalaRepository TipoSalaRepository();

    public List<TipoSala> findAll() {
        return TipoSalaRepository.findAll();
    }

    public TipoSala findById(Integer id) {
        return TipoSalaRepository.findById(id).orElse(null);
    }

    public TipoSala save(TipoSala tipoSala) {
        return TipoSalaRepository.save(tipoSala);
    }

    public void deleteById(Integer id) {
        TipoSalaRepository.deleteById(id);
    }
}
