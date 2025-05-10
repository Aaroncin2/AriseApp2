package pe.edu.upc.ariseapp.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.ariseapp.dtos.ForumDTO;
import pe.edu.upc.ariseapp.entities.Forum;
import pe.edu.upc.ariseapp.servicesinterfaces.IForumService;

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
    @PreAuthorize("hasAnyAuthority('ECOLOGISTA, ADMIN, VOLUNTARIO')")
    public void insertar(@RequestBody ForumDTO fDTO){
        ModelMapper modelMapper = new ModelMapper();
        Forum f= modelMapper.map(fDTO, Forum.class);
        fS.insert(f);
    }

    @GetMapping("/{idForum}")
    public ForumDTO listarId(@PathVariable("idForum") int idForum) {
        ModelMapper m = new ModelMapper();
        ForumDTO dto = m.map(fS.listId(idForum), ForumDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ECOLOGISTA', 'ADMIN','VOLUNTARIO')")
    public void modificar(@RequestBody ForumDTO fDTO) {
        ModelMapper m = new ModelMapper();
        Forum f = m.map(fDTO, Forum.class);
        fS.update(f);
    }

    @DeleteMapping("/{idForum}")
    @PreAuthorize("hasAnyAuthority('ECOLOGISTA', 'ADMIN','VOLUNTARIO')")
    public void eliminar(@PathVariable("idForum") int idForum) {
        fS.delete(idForum);
    }
}
