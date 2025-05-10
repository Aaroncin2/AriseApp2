package pe.edu.upc.ariseapp.servicesinterfaces;
import pe.edu.upc.ariseapp.entities.Mission;
import java.util.List;


public interface IMissionsService {
    public List<Mission> list();
    public void insert(Mission mi);
    public Mission listId(int idMissions);
    public void update(Mission mi);
    public void delete(int idMissions);
}