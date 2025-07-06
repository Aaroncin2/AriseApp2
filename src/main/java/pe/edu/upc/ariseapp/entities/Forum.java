package pe.edu.upc.ariseapp.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Forum")
public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idForum;

    @Column(name = "nameForum", nullable = false, length = 30)
    private String nameForum;

    @Column(name = "contentForum", nullable = false, length = 200)
    private String contentForum;

    @Column(name = "dateForum", nullable = false)
    private LocalDate dateForum;

    public Forum() {
    }

    public Forum(int idForum, String nameForum, String contentForum, LocalDate dateForum) {
        this.idForum = idForum;
        this.nameForum = nameForum;
        this.contentForum = contentForum;
        this.dateForum = dateForum;
    }

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
