package pe.edu.upc.ariseapp.entities;

import jakarta.persistence.*;

@Entity
@Table(name ="MissionReward")
public class MissionReward {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idMissionReward;

    @Column(name = "description" , nullable = false , length = 200)
    private String description;

    @ManyToOne
    @JoinColumn(name="idMission", nullable=false)
    private Mission mission;

    @ManyToOne
    @JoinColumn(name="idReward", nullable=false)
    private Reward reward;

    public MissionReward(){}

    public MissionReward(int idMissionReward, String description, Mission mission, Reward reward) {
        this.idMissionReward = idMissionReward;
        this.description = description;
        this.mission = mission;
        this.reward = reward;
    }

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
