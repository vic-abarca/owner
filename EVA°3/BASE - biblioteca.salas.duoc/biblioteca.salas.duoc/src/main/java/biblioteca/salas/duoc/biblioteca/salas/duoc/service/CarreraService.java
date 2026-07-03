package biblioteca.salas.duoc.biblioteca.salas.duoc.service;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Carrera;
import biblioteca.salas.duoc.biblioteca.salas.duoc.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarreraService {
    @Autowired
    private CarreraRepository CarreraRepository();

    public List<Carrera> findAll() {
        return CarreraRepository.findAll();
    }

    public Carrera findByCodigo(String codigo) {
        return CarreraRepository.findById(codigo).orElse(null);
    }

    public Carrera save(Carrera carrera) {
        return CarreraRepository.save(carrera);
    }

    public void deleteByCodigo(String codigo) {
        CarreraRepository.deleteById(codigo);
    }
}