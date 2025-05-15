package pe.edu.upc.ariseapp.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "Volunteering")
public class Volunteering {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idVolunteering;

    @Column(name = "nameVolunteering",nullable = false,length = 30)
    private String nameVolunteering;

    @Column(name = "activityVolunteering",nullable = false, length = 100)
    private String activityVolunteering;

    @Column(name = "attendanceVolunteering",nullable = false)
    private Boolean attendanceVolunteering;

    @Column(name = "areaVolunteering",nullable = false, length = 30)
    private String areaVolunteering;

    @ManyToOne
    @JoinColumn(name="idCampaign", nullable=false)
    private Campaign campaign;

    @ManyToOne
    @JoinColumn(name="idDonation", nullable=false)
    private Donation donation;

    @ManyToOne
    @JoinColumn(name="idRol", nullable=false)
    private Role role;

    public Volunteering() {
    }

    public Volunteering(int idVolunteering, String nameVolunteering, String activityVolunteering, Boolean attendanceVolunteering, String areaVolunteering, Campaign campaign, Donation donation, Role role) {
        this.idVolunteering = idVolunteering;
        this.nameVolunteering = nameVolunteering;
        this.activityVolunteering = activityVolunteering;
        this.attendanceVolunteering = attendanceVolunteering;
        this.areaVolunteering = areaVolunteering;
        this.campaign = campaign;
        this.donation = donation;
        this.role = role;
    }

    public int getIdVolunteering() {
        return idVolunteering;
    }

    public void setIdVolunteering(int idVolunteering) {
        this.idVolunteering = idVolunteering;
    }

    public String getNameVolunteering() {
        return nameVolunteering;
    }

    public void setNameVolunteering(String nameVolunteering) {
        this.nameVolunteering = nameVolunteering;
    }

    public String getActivityVolunteering() {
        return activityVolunteering;
    }

    public void setActivityVolunteering(String activityVolunteering) {
        this.activityVolunteering = activityVolunteering;
    }

    public Boolean getAttendanceVolunteering() {
        return attendanceVolunteering;
    }

    public void setAttendanceVolunteering(Boolean attendanceVolunteering) {
        this.attendanceVolunteering = attendanceVolunteering;
    }

    public String getAreaVolunteering() {
        return areaVolunteering;
    }

    public void setAreaVolunteering(String areaVolunteering) {
        this.areaVolunteering = areaVolunteering;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public Donation getDonation() {
        return donation;
    }

    public void setDonation(Donation donation) {
        this.donation = donation;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
