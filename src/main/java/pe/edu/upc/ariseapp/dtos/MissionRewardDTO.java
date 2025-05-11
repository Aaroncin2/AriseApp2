package pe.edu.upc.ariseapp.dtos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import pe.edu.upc.ariseapp.entities.Mission;
import pe.edu.upc.ariseapp.entities.Reward;

public class MissionRewardDTO {
    private int idMissionReward;
    @NotBlank(message = "La descripcion no puede estar vacío")
    @Size(max = 200, message = "La descripcion no puede tener más de 200 caracteres")
    private String description;
    private Mission mission;
    private Reward reward;

    public int getIdMissionReward() {
        return idMissionReward;
    }

    public void setIdMissionReward(int idMissionReward) {
        this.idMissionReward = idMissionReward;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    public Reward getReward() {
        return reward;
    }

    public void setReward(Reward reward) {
        this.reward = reward;
    }

}
