package pe.edu.upc.ariseapp.dtos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import pe.edu.upc.ariseapp.entities.Role;

import java.time.LocalDate;

public class CampaignDTO {
    private int idCampaign;
    @NotBlank(message = "El nombre de la campaña no puede estar vacío")
    @Size(max = 30, message = "El nombre de la campaña no puede tener más de 30 caracteres")
    private String nameCampaign;
    @NotBlank(message = "La descripcion de la campaña no puede estar vacío")
    @Size(max = 200, message = "La descripcion de la campaña no puede tener más de 200 caracteres")
    private String descriptionCampaign;
    @NotNull(message = "La fecha es obligatoria")
    private LocalDate dateCampaign;
    private Role role;

    public int getIdCampaign() {
        return idCampaign;
    }

    public void setIdCampaign(int idCampaign) {
        this.idCampaign = idCampaign;
    }

    public String getNameCampaign() {
        return nameCampaign;
    }

    public void setNameCampaign(String nameCampaign) {
        this.nameCampaign = nameCampaign;
    }

    public String getDescriptionCampaign() {
        return descriptionCampaign;
    }

    public void setDescriptionCampaign(String descriptionCampaign) {
        this.descriptionCampaign = descriptionCampaign;
    }

    public LocalDate getDateCampaign() {
        return dateCampaign;
    }

    public void setDateCampaign(LocalDate dateCampaign) {
        this.dateCampaign = dateCampaign;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
