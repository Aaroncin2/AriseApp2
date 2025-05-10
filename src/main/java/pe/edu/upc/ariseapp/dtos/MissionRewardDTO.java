package pe.edu.upc.ariseapp.dtos;
import pe.edu.upc.ariseapp.entities.Mission;
import pe.edu.upc.ariseapp.entities.Reward;

public class MissionRewardDTO {
    private int idMissionReward;
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
