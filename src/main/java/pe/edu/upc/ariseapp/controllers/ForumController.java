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
import pe.edu.upc.ariseapp.dtos.ForumDTO;
import pe.edu.upc.ariseapp.dtos.HU60DTO;
import pe.edu.upc.ariseapp.dtos.HU63DTO;
import pe.edu.upc.ariseapp.entities.Forum;
import pe.edu.upc.ariseapp.servicesinterfaces.IForumService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/forums")
public class ForumController {
    @Autowired
    private IForumService fS;

    public ForumController(){}

    @GetMapping
    public List<ForumDTO> listar(){
        return fS.list().stream().map(x->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, ForumDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ECOLOGISTA', 'ADMIN', 'VOLUNTARIO')")
    public void registrar( @RequestBody ForumDTO fDTO){
        ModelMapper modelMapper = new ModelMapper();
        Forum f= modelMapper.map(fDTO, Forum.class);
        fS.insert(f);

    }

    @GetMapping("/{idForum}")
    public ForumDTO listarId( @PathVariable("idForum") int idForum) {
        ModelMapper m = new ModelMapper();
        ForumDTO dto = m.map(fS.listId(idForum), ForumDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ECOLOGISTA', 'ADMIN','VOLUNTARIO')")
    public void modificar( @RequestBody ForumDTO fDTO) {
        ModelMapper m = new ModelMapper();
        Forum f = m.map(fDTO, Forum.class);
        fS.update(f);

    }

    @DeleteMapping("/{idForum}")
    @PreAuthorize("hasAnyAuthority('ECOLOGISTA', 'ADMIN','VOLUNTARIO')")
    public void eliminar(@Valid @PathVariable("idForum") @Min(1) @Max(50) int idForum) {
        fS.delete(idForum);
    }

    @GetMapping("/HU60")
    public List<HU60DTO> HU60() {
        List<HU60DTO> dtos = new ArrayList<>();
        List<String[]> filaLista = fS.forumsxComment();
        for(String[] columna : filaLista) {
            HU60DTO dto = new HU60DTO();
            dto.setUsername(columna[0]);
            dto.setContent_forum(columna[1]);
            dto.setDescription_forum(columna[2]);
            dtos.add(dto);
        }
        return dtos;
    }
    @GetMapping("/HU63")
    public List<HU63DTO> HU63(){
        List<HU63DTO> dtos = new ArrayList<>();
        List<String[]> filaLista = fS.userxForum();
        for(String[] columna : filaLista) {
            HU63DTO dto = new HU63DTO();
            dto.setUsername(columna[0]);
            dto.setName_forum(columna[1]);
            dtos.add(dto);
        }
        return dtos;
    }
}
