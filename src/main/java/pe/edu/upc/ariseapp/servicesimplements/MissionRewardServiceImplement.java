package pe.edu.upc.ariseapp.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.ariseapp.entities.MissionReward;
import pe.edu.upc.ariseapp.repositories.IMissionRewardServiceRepository;
import pe.edu.upc.ariseapp.servicesinterfaces.IMissionRewardService;

import java.util.List;

@Service
public class MissionRewardServiceImplement implements IMissionRewardService {
    @Autowired
    private IMissionRewardServiceRepository mR;

    @Override
    public List<MissionReward> list() {return mR.findAll();}

    @Override
    public void insert(MissionReward mr) {
        mR.save(mr);
    }

    @Override
    public MissionReward listId(int idMissionReward) {return mR.findById(idMissionReward).orElse(new MissionReward());}

    @Override
    public void update(MissionReward mr) {
        mR.save(mr);
    }

    @Override
    public void delete(int idMissionReward) {
        mR.deleteById(idMissionReward);
    }
    
}