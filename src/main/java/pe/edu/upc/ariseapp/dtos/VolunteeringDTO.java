package pe.edu.upc.ariseapp.dtos;
import pe.edu.upc.ariseapp.entities.Campaign;
import pe.edu.upc.ariseapp.entities.Donation;
import pe.edu.upc.ariseapp.entities.Role;

public class VolunteeringDTO {
    private int idVolunteering;
    private String nameVolunteering;
    private String activityVolunteering;
    private Boolean attendanceVolunteering;
    private String areaVolunteering;
    private Campaign campaign;
    private Donation donation;
    private Role role;

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
