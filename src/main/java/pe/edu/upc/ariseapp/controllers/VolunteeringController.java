package pe.edu.upc.ariseapp.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.ariseapp.dtos.HU59DTO;
import pe.edu.upc.ariseapp.dtos.VolunteeringDTO;
import pe.edu.upc.ariseapp.entities.Volunteering;
import pe.edu.upc.ariseapp.servicesinterfaces.IVolunteeringService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/volunteerings")
public class VolunteeringController {
    @Autowired
    private IVolunteeringService vS;

    public VolunteeringController() {}

    @GetMapping
    public List<VolunteeringDTO> listar(){
        return vS.list().stream().map(x->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, VolunteeringDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ECOLOGISTA', 'ADMIN')")
    public void insertar(@RequestBody VolunteeringDTO vDto){
        ModelMapper modelMapper = new ModelMapper();
        Volunteering v = modelMapper.map(vDto, Volunteering.class);
        vS.insert(v);
    }

    @GetMapping("/{idVolunteering}")
    public VolunteeringDTO listarId(@PathVariable("idVolunteering") int idVolunteering) {
        ModelMapper m = new ModelMapper();
        VolunteeringDTO dto = m.map(vS.listId(idVolunteering), VolunteeringDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ECOLOGISTA', 'ADMIN')")
    public void modificar(@RequestBody VolunteeringDTO vDto) {
        ModelMapper m = new ModelMapper();
        Volunteering v = m.map(vDto, Volunteering.class);
        vS.update(v);
    }
    @DeleteMapping("/{idVolunteering}")
    @PreAuthorize("hasAnyAuthority('ECOLOGISTA', 'ADMIN')")
    public void eliminar(@PathVariable("idVolunteering") int idVolunteering) {
        vS.delete(idVolunteering);
    }

    @GetMapping("/HU59")
    public List<HU59DTO> HU59(){
        List<HU59DTO> dtos = new ArrayList<>();
        List<String[]> filaLista = vS.userAttendance();
        for(String[] columna : filaLista){
            HU59DTO dto = new HU59DTO();
            dto.setId_volunteering(Integer.parseInt(columna[0]));
            dto.setName_volunteering(columna[1]);
            dto.setActivity_volunteering(columna[2]);
            dto.setUsername(columna[3]);
            dto.setAttendance_volunteering(Boolean.parseBoolean(columna[4]));
            dtos.add(dto);
        }
        return dtos;
    }
}
