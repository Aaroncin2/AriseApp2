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
import pe.edu.upc.ariseapp.dtos.CampaignDTO;
import pe.edu.upc.ariseapp.dtos.HU56DTO;
import pe.edu.upc.ariseapp.entities.Campaign;
import pe.edu.upc.ariseapp.servicesinterfaces.ICampaignService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/campaigns")
public class CampaignController {
    @Autowired
    private ICampaignService cS;

    public CampaignController() {
    }

    @GetMapping
    public List<CampaignDTO> listar(){
        return cS.list().stream().map(x->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, CampaignDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ECOLOGISTA', 'ADMIN')")
    public ResponseEntity<String> registrar(@Valid @RequestBody CampaignDTO cDto){
        ModelMapper modelMapper = new ModelMapper();
        Campaign c= modelMapper.map(cDto, Campaign.class);
        cS.insert(c);
        String mensaje = "Campaña registrada correctamente: " + cDto.getNameCampaign();
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @GetMapping("/{idCampaign}")
    public CampaignDTO listarId(@Valid @PathVariable("idCampaign") @Min(1) @Max(50) int idCampaign) {
        ModelMapper m = new ModelMapper();
        CampaignDTO dto = m.map(cS.listId(idCampaign), CampaignDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ECOLOGISTA', 'ADMIN')")
    public ResponseEntity<String> modificar(@Valid @RequestBody CampaignDTO cDTO) {
        ModelMapper m = new ModelMapper();
        Campaign c = m.map(cDTO, Campaign.class);
        cS.update(c);
        String mensaje = "Campaña modificada correctamente: " + cDTO.getNameCampaign();
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @DeleteMapping("/{idCampaign}")
    @PreAuthorize("hasAnyAuthority('ECOLOGISTA', 'ADMIN')")
    public void eliminar(@Valid @PathVariable("idCampaign") @Min(1) int idCampaign) {
        cS.delete(idCampaign);
    }

    @GetMapping("/HU56")
    public List<HU56DTO> HU56(){
        List<HU56DTO> dtos = new ArrayList<>();
        List<String[]> filaLista = cS.findCampaignsByUserAndRol();
        for(String[] columna : filaLista){
            HU56DTO dto = new HU56DTO();
            dto.setId_campaign(Integer.parseInt(columna[0]));
            dto.setCampaign_name(columna[1]);
            dto.setCampaign_description(columna[2]);
            dto.setUsername(columna[3]);
            dto.setRole(columna[4]);
            dtos.add(dto);
        }
            return dtos;
    }

}
