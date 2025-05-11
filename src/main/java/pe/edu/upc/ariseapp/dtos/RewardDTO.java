package pe.edu.upc.ariseapp.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RewardDTO {
    private int idReward;
    @NotBlank(message = "El nombre de la recompensa no puede estar vacío")
    @Size(max = 50, message = "El nombre de la recompensa no puede tener más de 50 caracteres")
    private String nameReward;

    public int getIdReward() {
        return idReward;
    }

    public void setIdReward(int idReward) {
        this.idReward = idReward;
    }

    public String getNameReward() {
        return nameReward;
    }

    public void setNameReward(String nameReward) {
        this.nameReward = nameReward;
    }

}
