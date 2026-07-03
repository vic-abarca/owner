package biblioteca.salas.duoc.biblioteca.salas.duoc.controller;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.TipoSala;
import biblioteca.salas.duoc.biblioteca.salas.duoc.service.TipoSalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-salas")
public class TipoSalaController {
    @Autowired
    private TipoSalaService tipoSalaService();

    @GetMapping
    public List<TipoSala> getAllTipoSalas() {
        return TipoSalaService.findAll();
    }

    @GetMapping("/{id}")
    public TipoSala getTipoSalaById(@PathVariable Integer id) {
        return TipoSalaService.findById(id);
    }

    @PostMapping
    public TipoSala createTipoSala(@RequestBody TipoSala tipoSala) {
        return TipoSalaService.save(tipoSala);
    }

    @PutMapping("/{id}")
    public TipoSala updateTipoSala(@PathVariable Integer id, @RequestBody TipoSala tipoSala) {
        tipoSala.setIdTipo(id);
        return TipoSalaService.save(tipoSala);
    }

    @DeleteMapping("/{id}")
    public void deleteTipoSala(@PathVariable Integer id) {
        TipoSalaService.deleteById(id);
    }
}
