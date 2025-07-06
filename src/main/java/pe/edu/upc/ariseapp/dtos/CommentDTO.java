package pe.edu.upc.ariseapp.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import pe.edu.upc.ariseapp.entities.Forum;
import pe.edu.upc.ariseapp.entities.Users;

import java.time.LocalDate;

public class CommentDTO {
    private int idComment;
    @NotBlank(message = "La categoria no puede estar vacío")
    @Size(max = 30, message = "La categoria no puede tener más de 30 caracteres")
    private String categoryComment;
    @NotBlank(message = "La descripcion de la categoria no puede estar vacío")
    @Size(max = 200, message = "La descripcion de la categoria no puede tener más de 200 caracteres")
    private String descriptionComment;
    @NotNull(message = "La fecha es obligatoria")
    private LocalDate dateComment;
    private Users users;
    private Forum forum;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    public String getCategoryComment() {
        return categoryComment;
    }

    public void setCategoryComment(String categoryComment) {
        this.categoryComment = categoryComment;
    }

    public String getDescriptionComment() {
        return descriptionComment;
    }

    public void setDescriptionComment(String descriptionComment) {
        this.descriptionComment = descriptionComment;
    }

    public LocalDate getDateComment() {
        return dateComment;
    }

    public void setDateComment(LocalDate dateComment) {
        this.dateComment = dateComment;
    }

}
