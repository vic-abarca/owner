package biblioteca.salas.duoc.biblioteca.salas.duoc.controller;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Carrera;
import biblioteca.salas.duoc.biblioteca.salas.duoc.service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateonas.collectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.hateonas.EntityModel;

import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/carreras")

public class CarreraController {
    @Autowired
    private CarreraService carreraService;

    @GetMapping
    public List<Carrera> getAllCarreras() {
        return carreraService.findAll();
    }

    @GetMapping("/{codigo}")
    public Carrera getCarreraByCodigo(@PathVariable String codigo) {
        return carreraService.findByCodigo(codigo);
    }

    @PostMapping
    public Carrera createCarrera(@RequestBody Carrera carrera) {
        return carreraService.save(carrera);
    }

    @PutMapping("/{codigo}")
    public Carrera updateCarrera(@PathVariable String codigo, @RequestBody Carrera carrera) {
        carrera.setCodigo(codigo);
        return carreraService.save(carrera);
    }

    @DeleteMapping("/{codigo}")
    public void deleteCarrera(@PathVariable String codigo) {
        carreraService.deleteByCodigo(codigo);
    }


    @Operation(summary = "Obtener todas las carreras",
    description = "Retorna una lista completa de carreras registradas en el sistema.")
    @ApiResponses({
    @ApiResponse(responseCode = "200", description = "Lista de carreras obtenida exitosamente"),
    @ApiResponse(responseCode = "404", description = "No exiete ninguna carrera registrada en el sistema"),
    })
    @Getmapping
    public List<Carrera> getAllCarreras() {
    return carreraService.findAll();
    }
    @Operation(
    summary = "Obtener carrera por código",
    description = "Retorna la información de una carrera específica según su código.")
    @ApiResponses({
    @ApiResponse(responseCode = "200", description = "Carrera obtenida exitosamente"),
    @ApiResponse(responseCode = "404", description = "No se encontró ninguna carrera con el código proporcionado"),
    })
    @GetMapping("/{codigo}")
    public Carrera getCarreraByCodigo(@PathVariable String codigo) {
    return carreraService.findByCodigo(codigo);
    }    
    @Operation(
    summary = "Crear una nueva carrera",
    description = "Permite registrar una nueva carrera en el sistema.")
    @Apiresponses({
    @Apiresponse(responsecode = "201", description = "Carrera creada exitosamente"),
    @Apiresponse(responsecode = "400", description = "Solicitud inválida, la carrera no pudo ser creada"),
    })
    @PostMapping
    public Carrera createCarrera(@RequestBody Carrera carrera) {
    return carreraService.save(carrera);
    }

@GetMapping("/{codigo}")
public EntityModel<Carrera> obtenerCarrera(@PathVariable String codigo) {

    Carrera carrera = carreraService.findByCodigo(codigo);

    return EntityModel.of(carrera,
            linkTo(methodOn(CarreraController.class)
            .obtenerCarrera(codigo)).withSelfRel(),
            linkTo(methodOn(CarreraController.class)
            .actualizarCarrera(codigo, carrera)).withRel("actualizar"),
            linkTo(methodOn(CarreraController.class)
            .eliminarCarrera(codigo)).withRel("eliminar"));
}
@GetMapping
public CollectionModel<EntityModel<Carrera>> obtenerCarreras() {

    List<EntityModel<Carrera>> carreras = carreraService.findAll()
            .stream()
            .map(carrera -> EntityModel.of(carrera,
                    linkTo(methodOn(CarreraController.class)
                            .obtenerCarrera(carrera.getCodigo())).withSelfRel(),
                    linkTo(methodOn(CarreraController.class)
                            .actualizarCarrera(carrera.getCodigo(), carrera)).withRel("actualizar"),
                    linkTo(methodOn(CarreraController.class)
                            .eliminarCarrera(carrera.getCodigo())).withRel("eliminar")))
            .collect(Collectors.toList());

    return CollectionModel.of(carreras,
            linkTo(methodOn(CarreraController.class)
                    .obtenerCarreras()).withSelfRel());
}


@PutMapping("/{codigo}")
public Carrera actualizarCarrera(@PathVariable String codigo,
                                 @RequestBody Carrera carrera) {
    return carreraService.update(codigo, carrera);
}

@DeleteMapping("/{codigo}")
public ResponseEntity<Void> eliminarCarrera(@PathVariable String codigo) {
    carreraService.delete(codigo);
    return ResponseEntity.noContent().build();
}


}