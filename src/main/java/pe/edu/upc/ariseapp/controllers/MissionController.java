package pe.edu.upc.ariseapp.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.ariseapp.dtos.HU58DTO;
import pe.edu.upc.ariseapp.dtos.MissionDTO;
import pe.edu.upc.ariseapp.entities.Mission;
import pe.edu.upc.ariseapp.servicesinterfaces.IMissionService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/missions")
public class MissionController {
    @Autowired
    private IMissionService mS;

    public MissionController() {}

    @GetMapping
    public List<MissionDTO> listar(){
        return mS.list().stream().map(x->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, MissionDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/{idMissions}")
    public MissionDTO listarId(@Valid @PathVariable("idMissions") @Min(1) @Max(50) int idMissions) {
        ModelMapper m = new ModelMapper();
        MissionDTO dto = m.map(mS.listId(idMissions), MissionDTO.class);
        return dto;
    }
    @PostMapping
    @PreAuthorize("hasAnyAuthority('ECOLOGISTA', 'ADMIN')")
    public ResponseEntity<String> registrar(@Valid@RequestBody MissionDTO mDto){
        ModelMapper modelMapper = new ModelMapper();
        Mission mi= modelMapper.map(mDto, Mission.class);
        mS.insert(mi);
        String mensaje = "Mision registrada correctamente: " + mDto.getNameMission();
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ECOLOGISTA', 'ADMIN')")
    public ResponseEntity<String> modificar(@Valid @RequestBody MissionDTO mDTO) {
        ModelMapper m = new ModelMapper();
        Mission mi = m.map(mDTO, Mission.class);
        mS.update(mi);
        String mensaje = "Mision modificada correctamente: " + mDTO.getNameMission();
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }
    @DeleteMapping("/{idMissions}")
    @PreAuthorize("hasAnyAuthority('ECOLOGISTA', 'ADMIN')")
    public void eliminar(@Valid @PathVariable("idMissions") @Min(1) int idMissions) {
        mS.delete(idMissions);
    }

    @GetMapping("/HU58")
    public List<HU58DTO> HU58(){
        List<HU58DTO> dtos = new ArrayList<>();
        List<String[]> filaLista = mS.missionsByUser();
        for(String[] columna : filaLista){
            HU58DTO dto = new HU58DTO();
            dto.setUsername(columna[0]);
            dto.setTotal_missions(Integer.parseInt(columna[1]));
            dtos.add(dto);
        }
        return dtos;
    }
}
