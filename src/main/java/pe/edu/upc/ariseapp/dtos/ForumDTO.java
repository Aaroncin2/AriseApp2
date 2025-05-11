package pe.edu.upc.ariseapp.dtos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ForumDTO {
    private int idForum;
    @NotBlank(message = "El nombre del foro no puede estar vacío")
    @Size(max = 30, message = "El nombre del foro no puede tener más de 30 caracteres")
    private String nameForum;
    @NotBlank(message = "La descripcion del foro no puede estar vacío")
    @Size(max = 200, message = "La descripcion  del foro no puede tener más de 200 caracteres")
    private String contentForum;
    private LocalDate dateForum;

    public int getIdForum() {
        return idForum;
    }

    public void setIdForum(int idForum) {
        this.idForum = idForum;
    }

    public String getNameForum() {
        return nameForum;
    }

    public void setNameForum(String nameForum) {
        this.nameForum = nameForum;
    }

    public String getContentForum() {
        return contentForum;
    }

    public void setContentForum(String contentForum) {
        this.contentForum = contentForum;
    }

    public LocalDate getDateForum() {
        return dateForum;
    }

    public void setDateForum(LocalDate dateForum) {
        this.dateForum = dateForum;
    }

}
