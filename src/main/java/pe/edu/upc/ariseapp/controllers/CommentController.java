package pe.edu.upc.ariseapp.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> registrar(@Valid @RequestBody CommentDTO cDto){
        ModelMapper modelMapper = new ModelMapper();
        Comment c= modelMapper.map(cDto, Comment.class);
        cS.insert(c);
        String mensaje = "Comentario registrado correctamente: " + cDto.getCategoryComment();
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @GetMapping("/{idComment}")
    public CommentDTO listarId(@Valid @PathVariable("idComment") @Min(1) @Max(50) int idComment) {
        ModelMapper m = new ModelMapper();
        CommentDTO dto = m.map(cS.listId(idComment), CommentDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ECOLOGISTA', 'ADMIN','VOLUNTARIO')")
    public ResponseEntity<String> modificar(@Valid @RequestBody CommentDTO cDTO) {
        ModelMapper m = new ModelMapper();
        Comment c = m.map(cDTO, Comment.class);
        cS.update(c);
        String mensaje = "Comentario modificado correctamente: " + cDTO.getCategoryComment();
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }
    
    @DeleteMapping("/{idComment}")
    @PreAuthorize("hasAnyAuthority('ECOLOGISTA', 'ADMIN','VOLUNTARIO')")
    public void eliminar(@Valid @PathVariable("idComment") @Min(1) int idComment) {
        cS.delete(idComment);
    }

    @GetMapping("/HU61")
    public List<HU61DTO> HU61(@Param("username") String username) {
        List<HU61DTO> dtos = new ArrayList<>();
        List<String[]> filaLista = cS.comentariosByNombreUsuario(username);
        for (String[] columna : filaLista) {
            HU61DTO dto = new HU61DTO();
            dto.setUsername(columna[0]);
            dto.setCategory_comment(columna[1]);
            dto.setDescription(columna[2]);
            dtos.add(dto);
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
