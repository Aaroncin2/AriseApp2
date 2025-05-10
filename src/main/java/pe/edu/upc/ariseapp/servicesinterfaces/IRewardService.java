package pe.edu.upc.ariseapp.servicesinterfaces;

import pe.edu.upc.ariseapp.entities.Reward;

import java.util.List;

public interface IRewardService {
    public List<Reward> list();
    public void insert(Reward re);
    public Reward listId(int idReward);
    public void update(Reward re);
    public void delete(int idReward);

}