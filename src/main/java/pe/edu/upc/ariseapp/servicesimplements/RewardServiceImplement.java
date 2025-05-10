package pe.edu.upc.ariseapp.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.ariseapp.entities.Reward;
import pe.edu.upc.ariseapp.repositories.IRewardRepository;
import pe.edu.upc.ariseapp.servicesinterfaces.IRewardService;

import java.util.List;

@Service
public class RewardServiceImplement implements IRewardService {
    @Autowired
    private IRewardRepository rR;

    @Override
    public List<Reward> list() {return rR.findAll();}

    @Override
    public void insert(Reward re) {
        rR.save(re);
    }

    @Override
    public Reward listId(int idReward) {return rR.findById(idReward).orElse(new Reward());}

    @Override
    public void update(Reward re) {
        rR.save(re);
    }

    @Override
    public void delete(int idReward) {
        rR.deleteById(idReward);
    }
}