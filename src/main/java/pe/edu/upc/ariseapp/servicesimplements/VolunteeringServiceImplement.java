package pe.edu.upc.ariseapp.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.ariseapp.entities.Volunteering;
import pe.edu.upc.ariseapp.repositories.IVolunteeringRepository;
import pe.edu.upc.ariseapp.servicesinterfaces.IVolunteeringService;

import java.util.List;

@Service
public class VolunteeringServiceImplement implements IVolunteeringService {
    @Autowired
    private IVolunteeringRepository vR;

    @Override
    public List<Volunteering> list() {return vR.findAll();}

    @Override
    public void insert(Volunteering v) {
        vR.save(v);
    }

    @Override
    public Volunteering listId(int idVolunteering) {return vR.findById(idVolunteering).orElse(new Volunteering());}

    @Override
    public void update(Volunteering v) {
        vR.save(v);
    }

    @Override
    public void delete(int idVolunteering) {
        vR.deleteById(idVolunteering);
    }
}