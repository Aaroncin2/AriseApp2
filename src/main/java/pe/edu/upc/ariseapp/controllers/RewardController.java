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
import pe.edu.upc.ariseapp.dtos.RewardDTO;
import pe.edu.upc.ariseapp.entities.Reward;
import pe.edu.upc.ariseapp.servicesinterfaces.IRewardService;

import java.util.List;
import java.util.stream.Collectors;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/rewards")
public class RewardController {
    @Autowired
    private IRewardService rS;

    public RewardController() {}

    @GetMapping
    public List<RewardDTO> listar(){
        return rS.list().stream().map(x->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, RewardDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ECOLOGISTA', 'ADMIN')")
    public void registrar( @RequestBody RewardDTO rDTO){
        ModelMapper modelMapper = new ModelMapper();
        Reward re= modelMapper.map(rDTO, Reward.class);
        rS.insert(re);

    }

    @GetMapping("/{idReward}")
    public RewardDTO listarId( @PathVariable("idReward") @Min(1) @Max(50) int idReward) {
        ModelMapper m = new ModelMapper();
        RewardDTO dto = m.map(rS.listId(idReward), RewardDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ECOLOGISTA', 'ADMIN')")
    public void modificar(@Valid @RequestBody RewardDTO rDTO) {
        ModelMapper m = new ModelMapper();
        Reward re = m.map(rDTO, Reward.class);
        rS.update(re);

    }

    @DeleteMapping("/{idReward}")
    @PreAuthorize("hasAnyAuthority('ECOLOGISTA', 'ADMIN')")
    public void eliminar( @PathVariable("idReward") @Min(1) int idReward) {
        rS.delete(idReward);
    }
}
