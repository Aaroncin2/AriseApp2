package pe.edu.upc.ariseapp.entities;

import jakarta.persistence.*;

@Entity
@Table(name= "Mission")
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMission;

    @Column(name ="nameMission",nullable = false,length=30)
    private String nameMission;

    @Column(name ="descriptionMission", nullable = false,length=200)
    private String descriptionMission;

    @ManyToOne
    @JoinColumn(name="idUser", nullable=false)
    private Users users;

    public Mission() {
    }

    public Mission(int idMission, String nameMission, String descriptionMission, Users users) {
        this.idMission = idMission;
        this.nameMission = nameMission;
        this.descriptionMission = descriptionMission;
        this.users = users;
    }

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
