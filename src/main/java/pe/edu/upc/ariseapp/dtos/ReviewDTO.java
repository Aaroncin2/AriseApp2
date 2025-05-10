package pe.edu.upc.ariseapp.dtos;
import pe.edu.upc.ariseapp.entities.*;

public class ReviewDTO {
    private int idReview;
    private String categoryReview;
    private int qualificationReview;
    private String textReview;
    private Users users;
    private Mission mission;
    private Reward reward;
    private Volunteering volunteering;
    private Campaign campaign;

    public int getIdReview() {
        return idReview;
    }

    public void setIdReview(int idReview) {
        this.idReview = idReview;
    }

    public String getCategoryReview() {
        return categoryReview;
    }

    public void setCategoryReview(String categoryReview) {
        this.categoryReview = categoryReview;
    }

    public int getQualificationReview() {
        return qualificationReview;
    }

    public void setQualificationReview(int qualificationReview) {
        this.qualificationReview = qualificationReview;
    }

    public String getTextReview() {
        return textReview;
    }

    public void setTextReview(String textReview) {
        this.textReview = textReview;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    public Reward getReward() {
        return reward;
    }

    public void setReward(Reward reward) {
        this.reward = reward;
    }

    public Volunteering getVolunteering() {
        return volunteering;
    }

    public void setVolunteering(Volunteering volunteering) {
        this.volunteering = volunteering;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

}
