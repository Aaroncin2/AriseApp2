package pe.edu.upc.ariseapp.servicesinterfaces;

import pe.edu.upc.ariseapp.entities.MissionReward;

import java.util.List;

public interface IMissionRewardService {
    public List<MissionReward> list();
    public void insert(MissionReward mr);
    public MissionReward listId(int idMissionReward);
    public void update(MissionReward mr);
    public void delete(int idMissionReward);
}