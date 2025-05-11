package pe.edu.upc.ariseapp.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.ariseapp.dtos.CommentDTO;
import pe.edu.upc.ariseapp.dtos.HU61DTO;
import pe.edu.upc.ariseapp.dtos.HU62DTO;
import pe.edu.upc.ariseapp.entities.Comment;
import pe.edu.upc.ariseapp.servicesinterfaces.ICommentService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private ICommentService cS;

    public CommentController() {}

    @GetMapping
    public List<CommentDTO> listar(){
        return cS.list().stream().map(x->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, CommentDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ECOLOGISTA', 'ADMIN','VOLUNTARIO')")
    public void insertar(@RequestBody CommentDTO cDto){
        ModelMapper modelMapper = new ModelMapper();
        Comment c= modelMapper.map(cDto, Comment.class);
        cS.insert(c);
    }

    @GetMapping("/{idComment}")
    public CommentDTO listarId(@PathVariable("idComment") int idComment) {
        ModelMapper m = new ModelMapper();
        CommentDTO dto = m.map(cS.listId(idComment), CommentDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ECOLOGISTA', 'ADMIN','VOLUNTARIO')")
    public void modificar(@RequestBody CommentDTO cDTO) {
        ModelMapper m = new ModelMapper();
        Comment c = m.map(cDTO, Comment.class);
        cS.update(c);
    }
    
    @DeleteMapping("/{idComment}")
    @PreAuthorize("hasAnyAuthority('ECOLOGISTA', 'ADMIN','VOLUNTARIO')")
    public void eliminar(@PathVariable("idComment") int idComment) {
        cS.delete(idComment);
    }

    @GetMapping("/HU61")
    public List<HU61DTO> HU56(@Param("username") String username) {
        List<HU61DTO> dtos = new ArrayList<>();
        List<String[]> filaLista = cS.comentariosByNombreUsuario(username);
        for (String[] columna : filaLista) {
            HU61DTO dto = new HU61DTO();
            dto.setUsername(columna[0]);
            dto.setCategory_comment(columna[1]);
            dto.setDescription(columna[2]);
        }
        return dtos;
    }
    @GetMapping("/HU62")
    public List<HU62DTO> HU62(){
        List<HU62DTO> dtos = new ArrayList<>();
        List<String[]> filaLista = cS.countCommentsByUsers();
        for (String[] columna : filaLista) {
            HU62DTO dto = new HU62DTO();
            dto.setUsername(columna[0]);
            dto.setTotalComments(Integer.parseInt(columna[1]));
            dtos.add(dto);
        }
        return dtos;
    }

}
