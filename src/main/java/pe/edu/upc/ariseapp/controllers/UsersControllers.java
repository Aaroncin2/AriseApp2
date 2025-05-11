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
import pe.edu.upc.ariseapp.dtos.HU56DTO;
import pe.edu.upc.ariseapp.dtos.HU57DTO;
import pe.edu.upc.ariseapp.dtos.UsersDTO;
import pe.edu.upc.ariseapp.entities.Users;
import pe.edu.upc.ariseapp.servicesinterfaces.IUserService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/users")
public class UsersControllers {
    @Autowired
    private IUserService uS;

    public UsersControllers() {
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ECOLOGISTA', 'ADMIN')")
    public List<UsersDTO> listar() {
        return uS.list().stream().map(x-> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x,UsersDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<String> registrar(@Valid @RequestBody UsersDTO uDTO) {
        ModelMapper m = new ModelMapper();
        Users u = m.map(uDTO, Users.class);
        uS.insert(u);
        String mensaje = "User registrado correctamente: " + uDTO.getUsername();
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @GetMapping("/{idUser}")
    @PreAuthorize("hasAnyAuthority('ECOLOGISTA', 'ADMIN')")
    public UsersDTO listarId(@Valid @PathVariable("idUser") @Min(1) @Max(50) int idUser) {
        ModelMapper m = new ModelMapper();
        UsersDTO dto = m.map(uS.listId(idUser), UsersDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ECOLOGISTA', 'ADMIN', 'VOLUNTARIO')")
    public ResponseEntity<String> modificar(@Valid @RequestBody UsersDTO uDTO) {
        ModelMapper m = new ModelMapper();
        Users u = m.map(uDTO, Users.class);
        uS.update(u);
        String mensaje = "Usuario modificado correctamente: " + uDTO.getUsername();
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @DeleteMapping("/{idUser}")
    public void eliminar(@PathVariable ("idUser") @Min(1) int idUser) {
        uS.delete(idUser);
    }

    @GetMapping("/HU57")
    public List<HU57DTO> HU57() {
        List<HU57DTO> dtos = new ArrayList<>();
        List<String[]> filaLista  = uS.UsersAndRol();
        for(String[] columna : filaLista) {
            HU57DTO dto = new HU57DTO();
            dto.setId_user(Integer.parseInt(columna[0]));
            dto.setUsername(columna[1]);
            dto.setEmail(columna[2]);
            dto.setRole(columna[3]);
        }
        return dtos;
    }
}
