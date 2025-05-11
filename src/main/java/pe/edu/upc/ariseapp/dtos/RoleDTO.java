package pe.edu.upc.ariseapp.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import pe.edu.upc.ariseapp.entities.Users;

public class RoleDTO {
    private Long idRol;
    @NotBlank(message = "El nombre del rol no puede estar vacío")
    @Size(max = 30, message = "El nombre del rol no puede tener más de 30 caracteres")
    private String rol;
    private Users user;

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
