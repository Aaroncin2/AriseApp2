package pe.edu.upc.ariseapp.servicesinterfaces;


import pe.edu.upc.ariseapp.entities.Campaign;

import java.util.List;

public interface ICampaignService {
    public List<Campaign> list();
    public void insert(Campaign c);
    public Campaign listId(int idCampaign);
    public void update(Campaign c);
    public void delete(int idCampaign);
}