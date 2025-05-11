package pe.edu.upc.ariseapp.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.ariseapp.dtos.HU55DTO;
import pe.edu.upc.ariseapp.dtos.MissionRewardDTO;
import pe.edu.upc.ariseapp.entities.MissionReward;
import pe.edu.upc.ariseapp.servicesinterfaces.IMissionRewardService;

import java.util.ArrayList;
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

    @GetMapping("/HU55")
    public List<HU55DTO> HU55(){
        List<HU55DTO> dtos = new ArrayList<>();
        List<String[]> filaLista = mS.findMissionsWithMultipleRewards();
        for(String[] fila : filaLista){
            HU55DTO dto = new HU55DTO();
            dto.setId_missions(Integer.parseInt(fila[0]));
            dto.setTotal_rewards(Integer.parseInt(fila[1]));
            dtos.add(dto);
        }
        return dtos;
    }
}
