package pe.edu.upc.ariseapp.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    private List<Users> listar() {
        return uS.list().stream().map(x-> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x,Users.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody UsersDTO uDTO) {
        ModelMapper m = new ModelMapper();
        Users u = m.map(uDTO, Users.class);
        uS.insert(u);
    }

    @GetMapping("/{idUser}")
    @PreAuthorize("hasAnyAuthority('ECOLOGISTA', 'ADMIN')")
    public UsersDTO listarId(@PathVariable("idUser") int idUser) {
        ModelMapper m = new ModelMapper();
        UsersDTO dto = m.map(uS.listId(idUser), UsersDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ECOLOGISTA', 'ADMIN', 'VOLUNTARIO')")
    public void modificar(@RequestBody UsersDTO uDTO) {
        ModelMapper m = new ModelMapper();
        Users u = m.map(uDTO, Users.class);
        uS.update(u);
    }

    @DeleteMapping("/{idUser}")
    public void eliminar(@PathVariable int idUser) {
        uS.delete(idUser);
    }

    @GetMapping
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
