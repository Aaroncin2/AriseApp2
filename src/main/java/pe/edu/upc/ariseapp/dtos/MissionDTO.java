package pe.edu.upc.ariseapp.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import pe.edu.upc.ariseapp.entities.Users;

public class MissionDTO {
    private int idMission;
    @NotBlank(message = "El nombre de la mision no puede estar vacío")
    @Size(max = 30, message = "El nombre de la mision no puede tener más de 30 caracteres")
    private String nameMission;
    @NotBlank(message = "La descripcion de la mision no puede estar vacío")
    @Size(max = 200, message = "La descripcion de la mision no puede tener más de 200 caracteres")
    private String descriptionMission;
    private Users users;

    public int getIdMission() {
        return idMission;
    }

    public void setIdMission(int idMission) {
        this.idMission = idMission;
    }

    public String getNameMission() {
        return nameMission;
    }

    public void setNameMission(String nameMission) {
        this.nameMission = nameMission;
    }

    public String getDescriptionMission() {
        return descriptionMission;
    }

    public void setDescriptionMission(String descriptionMission) {
        this.descriptionMission = descriptionMission;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

}
