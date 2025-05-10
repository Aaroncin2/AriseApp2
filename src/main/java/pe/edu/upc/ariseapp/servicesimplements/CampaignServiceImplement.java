package pe.edu.upc.ariseapp.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.ariseapp.entities.Campaign;
import pe.edu.upc.ariseapp.repositories.ICampaignRepository;
import pe.edu.upc.ariseapp.servicesinterfaces.ICampaignService;


import java.util.List;

@Service
public class CampaignServiceImplement implements ICampaignService {

    @Autowired
    private ICampaignRepository cR;

    @Override
    public List<Campaign> list() {return cR.findAll();}

    @Override
    public void insert(Campaign c) {
        cR.save(c);
    }

    @Override
    public Campaign listId(int idCampaign) {return cR.findById(idCampaign).orElse(new Campaign());}

    @Override
    public void update(Campaign c) {
        cR.save(c);
    }

    @Override
    public void delete(int idCampaign) {
        cR.deleteById(idCampaign);
    }

}