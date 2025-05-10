package pe.edu.upc.ariseapp.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.ariseapp.entities.Donation;
import pe.edu.upc.ariseapp.repositories.IDonationRepository;
import pe.edu.upc.ariseapp.servicesinterfaces.IDonationService;

import java.util.List;

@Service
public class DonationServiceImplement implements IDonationService {
    @Autowired
    private IDonationRepository dR;

    @Override
    public List<Donation> list() {return dR.findAll();}

    @Override
    public void insert(Donation d) {
        dR.save(d);
    }

    @Override
    public Donation listId(int idDonation) {return dR.findById(idDonation).orElse(new Donation());}

    @Override
    public void update(Donation d) {
        dR.save(d);
    }

    @Override
    public void delete(int idDonation) {
        dR.deleteById(idDonation);
    }

}