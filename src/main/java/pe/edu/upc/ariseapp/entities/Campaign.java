package pe.edu.upc.ariseapp.entities;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Campaign")
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCampaign;

    @Column(name="nameCampaign", nullable = false,length = 200)
    private String nameCampaign;

    @Column(name="descriptionCampaign", nullable = false, length = 200)
    private String descriptionCampaign;

    @Column(name = "dateCampaign", nullable = false)
    private LocalDate dateCampaign;

    @ManyToOne
    @JoinColumn(name="idRol", nullable = false)
    private Role role;

    public Campaign() {}

    public Campaign(int idCampaign, String nameCampaign, String descriptionCampaign, LocalDate dateCampaign, Role role) {
        this.idCampaign = idCampaign;
        this.nameCampaign = nameCampaign;
        this.descriptionCampaign = descriptionCampaign;
        this.dateCampaign = dateCampaign;
        this.role = role;
    }

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
