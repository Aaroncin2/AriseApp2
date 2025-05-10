package pe.edu.upc.ariseapp.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.ariseapp.dtos.MissionRewardDTO;
import pe.edu.upc.ariseapp.entities.MissionReward;
import pe.edu.upc.ariseapp.servicesinterfaces.IMissionRewardService;

import java.util.List;
import java.util.stream.Collectors;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/missionRewards")
public class MissionRewardController {
    @Autowired
    private IMissionRewardService mS;

    public MissionRewardController() {}

    @GetMapping
    public List<MissionRewardDTO> listar(){
        return mS.list().stream().map(x->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, MissionRewardDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ECOLOGISTA', 'ADMIN')")
    public void insertar(@RequestBody MissionRewardDTO mDto){
        ModelMapper modelMapper = new ModelMapper();
        MissionReward mr= modelMapper.map(mDto, MissionReward.class);
        mS.insert(mr);
    }

    @GetMapping("/{idMissionReward}")
    public MissionRewardDTO listarId(@PathVariable("idMissionReward") int idMissionReward) {
        ModelMapper m = new ModelMapper();
        MissionRewardDTO dto = m.map(mS.listId(idMissionReward), MissionRewardDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ECOLOGISTA', 'ADMIN')")
    public void modificar(@RequestBody MissionRewardDTO mDTO) {
        ModelMapper m = new ModelMapper();
        MissionReward mr = m.map(mDTO, MissionReward.class);
        mS.update(mr);
    }

    @DeleteMapping("/{idMissionReward}")
    @PreAuthorize("hasAnyAuthority('ECOLOGISTA', 'ADMIN')")
    public void eliminar(@PathVariable("idMissionReward") int idMissionReward) {
        mS.delete(idMissionReward);
    }
}
