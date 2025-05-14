package pe.edu.upc.ariseapp.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import pe.edu.upc.ariseapp.entities.Role;

import java.util.List;

public class UsersDTO {
    private Long idUser;
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 30, message = "El nombre no puede tener más de 30 caracteres")
    private String username;
    @NotBlank(message = "La contraseña no puede estar vacío")
    @Size(max = 200, message = "El nombre no puede tener más de 200 caracteres")
    private String password;
    @NotNull(message = "El campo es obligatorio")
    private Boolean enabled;
    @NotBlank(message = "El email no puede estar vacío")
    @NotNull(message = "El email es obligatorio")
    private String email;
    private List<Role> roles;

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRoles() {return roles;}

    public void setRoles(List<Role> roles) {this.roles = roles;}
}
