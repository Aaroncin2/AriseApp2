package pe.edu.upc.ariseapp.dtos;
import pe.edu.upc.ariseapp.entities.Role;

import java.time.LocalDate;

public class CampaignDTO {
    private int idCampaign;
    private String nameCampaign;
    private String descriptionCampaign;
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
