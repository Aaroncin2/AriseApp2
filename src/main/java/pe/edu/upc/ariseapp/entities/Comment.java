package pe.edu.upc.ariseapp.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComment;

    @Column(name = "categoryComment",nullable = false,length = 20)
    private String categoryComment;

    @Column(name = "descriptionComment",nullable = false, length = 100)
    private String descriptionComment;

    @Column(name = "dateComment",nullable = false)
    private LocalDate dateComment;

    @ManyToOne
    @JoinColumn(name="idUser", nullable=false)
    private Users users;

    @ManyToOne
    @JoinColumn(name="idForum", nullable=false)
    private Forum forum;

    public Comment() {
    }

    public Comment(int idComment, String categoryComment, String descriptionComment, LocalDate dateComment) {
        this.idComment = idComment;
        this.categoryComment = categoryComment;
        this.descriptionComment = descriptionComment;
        this.dateComment = dateComment;
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
