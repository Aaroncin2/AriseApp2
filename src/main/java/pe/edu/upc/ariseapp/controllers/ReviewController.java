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
import pe.edu.upc.ariseapp.dtos.ReviewDTO;
import pe.edu.upc.ariseapp.entities.Review;
import pe.edu.upc.ariseapp.servicesinterfaces.IReviewService;

import java.util.List;
import java.util.stream.Collectors;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private IReviewService rS;

    public ReviewController() {}

    @GetMapping
    public List<ReviewDTO> listar(){
        return rS.list().stream().map(x->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, ReviewDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ECOLOGISTA', 'ADMIN')")
    public ResponseEntity<String> registrar(@Valid @RequestBody ReviewDTO rDto){
        ModelMapper modelMapper = new ModelMapper();
        Review r = modelMapper.map(rDto, Review.class);
        rS.insert(r);
        String mensaje = "Review registrado correctamente: " + rDto.getCategoryReview();
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @GetMapping("/{idReview}")
    public ReviewDTO listarId(@Valid @PathVariable("idReview") @Min(1) @Max(50) int idReview) {
        ModelMapper m = new ModelMapper();
        ReviewDTO dto = m.map(rS.listId(idReview), ReviewDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ECOLOGISTA', 'ADMIN')")
    public ResponseEntity<String> modificar(@Valid @RequestBody ReviewDTO rDTO) {
        ModelMapper m = new ModelMapper();
        Review r = m.map(rDTO, Review.class);
        rS.update(r);
        String mensaje = "Review modificado correctamente: " + rDTO.getCategoryReview();
        return new ResponseEntity<>(mensaje, HttpStatus.OK);

    }

    @DeleteMapping("/{idReview}")
    @PreAuthorize("hasAnyAuthority('ECOLOGISTA', 'ADMIN')")
    public void eliminar(@Valid @PathVariable("idReview") @Min(1) int idReview) {
        rS.delete(idReview);
    }
}

