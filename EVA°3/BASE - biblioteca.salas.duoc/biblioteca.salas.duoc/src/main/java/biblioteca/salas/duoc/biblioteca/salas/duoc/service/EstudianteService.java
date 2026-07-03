package biblioteca.salas.duoc.biblioteca.salas.duoc.service;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Estudiante;
import biblioteca.salas.duoc.biblioteca.salas.duoc.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository EstudianteRepository();

    public List<Estudiante> findAll() {
        return EstudianteRepository.findAll();
    }

    public Estudiante findById(Integer id) {
        return EstudianteRepository.findById(id).orElse(null);
    }

    public Estudiante save(Estudiante estudiante) {
        return EstudianteRepository.save(estudiante);
    }

    public void deleteById(Integer id) {
        EstudianteRepository.deleteById(id);
    }
}