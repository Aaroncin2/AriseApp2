package pe.edu.upc.ariseapp.entities;

import jakarta.persistence.*;

@Entity
@Table(name ="Reward")
public class Reward {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idReward;

    @Column(name = "nameReward", nullable = false, length = 50)
    private String nameReward;

    public Reward() {}

    public Reward(int idReward, String nameReward) {
        this.idReward = idReward;
        this.nameReward = nameReward;
    }

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
