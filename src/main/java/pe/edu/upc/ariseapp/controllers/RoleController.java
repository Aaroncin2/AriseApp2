package pe.edu.upc.ariseapp.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.ariseapp.dtos.RoleDTO;
import pe.edu.upc.ariseapp.entities.Role;
import pe.edu.upc.ariseapp.servicesinterfaces.IRoleService;

import java.util.List;
import java.util.stream.Collectors;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/rols")
public class RoleController {
    @Autowired
    private IRoleService rS;

    public RoleController() {
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<RoleDTO> listar() {
        return rS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RoleDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> registrar(@Valid @RequestBody RoleDTO rDTO) {
        ModelMapper m = new ModelMapper();
        Role r = m.map(rDTO, Role.class);
        rS.insert(r);
        String mensaje = "Rol registrado correctamente: " + rDTO.getRol();
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @GetMapping("/{idRol}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public RoleDTO listarId(@Valid @PathVariable("idRol") @Min(1) @Max(50) int idRol) {
        ModelMapper m = new ModelMapper();
        RoleDTO dto = m.map(rS.listId(idRol), RoleDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> modificar(@Valid @RequestBody RoleDTO rDTO) {
        ModelMapper m = new ModelMapper();
        Role r = m.map(rDTO, Role.class);
        rS.update(r);
        String mensaje = "Usuario modificado correctamente: " + rDTO.getRol();
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @DeleteMapping("/{idRol}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@Valid @PathVariable @Min(1) int idRol) {
        rS.delete(idRol);
    }
}
