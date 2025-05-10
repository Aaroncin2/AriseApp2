package pe.edu.upc.ariseapp.dtos;

import pe.edu.upc.ariseapp.entities.Forum;
import pe.edu.upc.ariseapp.entities.Users;

import java.time.LocalDate;

public class CommentDTO {
    private int idComment;
    private String categoryComment;
    private String descriptionComment;
    private LocalDate dateComment;
    private Users users;
    private Forum forum;

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
