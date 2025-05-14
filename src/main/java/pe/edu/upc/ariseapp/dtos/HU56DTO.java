package pe.edu.upc.ariseapp.dtos;


public class HU56DTO {
    private int id_campaign;
    private String campaign_name;
    private String campaign_description;
    private String username;
    private String role;

    public int getId_campaign() {
        return id_campaign;
    }

    public void setId_campaign(int id_campaign) {
        this.id_campaign = id_campaign;
    }

    public String getCampaign_name() {
        return campaign_name;
    }

    public void setCampaign_name(String campaign_name) {
        this.campaign_name = campaign_name;
    }

    public String getCampaign_description() {
        return campaign_description;
    }

    public void setCampaign_description(String campaign_description) {
        this.campaign_description = campaign_description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
