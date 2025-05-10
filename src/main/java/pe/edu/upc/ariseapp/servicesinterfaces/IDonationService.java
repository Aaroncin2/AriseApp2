package pe.edu.upc.ariseapp.servicesinterfaces;

import pe.edu.upc.ariseapp.entities.Donation;

import java.util.List;

public interface IDonationService {
    public List<Donation> list();
    public void insert(Donation d);
    public Donation listId(int idDonation);
    public void update(Donation d);
    public void delete(int idDonation);
}