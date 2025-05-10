package pe.edu.upc.ariseapp.servicesinterfaces;


import pe.edu.upc.ariseapp.entities.Volunteering;

import java.util.List;

public interface IVolunteeringService {
    public List<Volunteering> list();
    public void insert(Volunteering v);
    public Volunteering listId(int idVolunteering);
    public void update(Volunteering v);
    public void delete(int idVolunteering);

}