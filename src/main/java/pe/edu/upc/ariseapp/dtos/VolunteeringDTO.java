package pe.edu.upc.ariseapp.dtos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import pe.edu.upc.ariseapp.entities.Campaign;
import pe.edu.upc.ariseapp.entities.Donation;
import pe.edu.upc.ariseapp.entities.Role;

public class VolunteeringDTO {
    private int idVolunteering;
    @NotNull(message = "El nombre es obligatoria")
    @Size(max = 30, message = "El nombre no puede tener más de 30 caracteres")
    @NotBlank(message = "El nombre del voluntariado no puede estar vacío")
    private String nameVolunteering;
    @NotNull(message = "La actividad es obligatoria")
    @Size(max = 100, message = "El nombre de la actividad no puede tener más de 100 caracteres")
    private String activityVolunteering;
    @NotNull(message = "La asistencia del cvoluntariado es obligatorio")
    private Boolean attendanceVolunteering;
    @NotNull(message = "El area del voluntariado es obligatoria")
    @Size(max = 30, message = "El nombre del voluntariado no puede tener más de 30 caracteres")
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
