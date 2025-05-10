package pe.edu.upc.ariseapp.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReview;

    @Column(name = "categoryReview", nullable = false, length=200)
    private String categoryReview;

    @Column(name = "qualificationReview", nullable = false)
    private int qualificationReview;

    @Column(name = "textReview", nullable = false, length=200)
    private String textReview;

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private Users users;

    @ManyToOne
    @JoinColumn(name = "idMission", nullable = false)
    private Mission mission;

    @ManyToOne
    @JoinColumn(name = "idReward", nullable = false)
    private Reward reward;

    @ManyToOne
    @JoinColumn(name = "idVolunteering", nullable = false)
    private Volunteering volunteering;

    @ManyToOne
    @JoinColumn(name = "idCampaign", nullable = false)
    private Campaign campaign;

    public Review() {
    }

    public Review(int idReview, String categoryReview, int qualificationReview, String textReview, Users users, Mission mission, Reward reward, Volunteering volunteering, Campaign campaign) {
        this.idReview = idReview;
        this.categoryReview = categoryReview;
        this.qualificationReview = qualificationReview;
        this.textReview = textReview;
        this.users = users;
        this.mission = mission;
        this.reward = reward;
        this.volunteering = volunteering;
        this.campaign = campaign;
    }

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
