package pe.edu.upc.ariseapp.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.ariseapp.entities.Mission;
import pe.edu.upc.ariseapp.repositories.IMissionRepository;
import pe.edu.upc.ariseapp.servicesinterfaces.IMissionsService;

import java.util.List;

@Service
public class MissionsServiceImplement implements IMissionsService {
    @Autowired
    private IMissionRepository mR;

    @Override
    public List<Mission> list() {return mR.findAll();}

    @Override
    public void insert(Mission mi) {
        mR.save(mi);
    }

    @Override
    public Mission listId(int idMission) {return mR.findById(idMission).orElse(new Mission());}

    @Override
    public void update(Mission mi) {
        mR.save(mi);
    }

    @Override
    public void delete(int idMission) {
        mR.deleteById(idMission);
    }

    @Override
    public List<String[]> missionsByUser() {
        return mR.missionsByUser();
    }
}