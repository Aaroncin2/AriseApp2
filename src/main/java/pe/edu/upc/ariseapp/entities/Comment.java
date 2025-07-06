package pe.edu.upc.ariseapp.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComment;

    @Column(name = "categoryComment",nullable = false,length = 30)
    private String categoryComment;

    @Column(name = "descriptionComment",nullable = false, length = 200)
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

    public Comment(int idComment, String categoryComment, String descriptionComment, Users users, LocalDate dateComment, Forum forum) {
        this.idComment = idComment;
        this.categoryComment = categoryComment;
        this.descriptionComment = descriptionComment;
        this.users = users;
        this.dateComment = dateComment;
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
}
