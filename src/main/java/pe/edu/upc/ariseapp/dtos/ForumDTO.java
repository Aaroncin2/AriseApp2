package pe.edu.upc.ariseapp.dtos;
import java.time.LocalDate;

public class ForumDTO {
    private int idForum;
    private String nameForum;
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
