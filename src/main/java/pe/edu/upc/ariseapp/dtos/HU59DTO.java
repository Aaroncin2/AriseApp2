package pe.edu.upc.ariseapp.dtos;

public class HU59DTO {
    private int id_volunteering;
    private String name_volunteering;
    private String activity_volunteering;
    private String username;
    private Boolean attendance_volunteering;

    public int getId_volunteering() {
        return id_volunteering;
    }

    public void setId_volunteering(int id_volunteering) {
        this.id_volunteering = id_volunteering;
    }

    public String getName_volunteering() {
        return name_volunteering;
    }

    public void setName_volunteering(String name_volunteering) {
        this.name_volunteering = name_volunteering;
    }

    public String getActivity_volunteering() {
        return activity_volunteering;
    }

    public void setActivity_volunteering(String activity_volunteering) {
        this.activity_volunteering = activity_volunteering;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getAttendance_volunteering() {
        return attendance_volunteering;
    }

    public void setAttendance_volunteering(Boolean attendance_volunteering) {
        this.attendance_volunteering = attendance_volunteering;
    }
}
