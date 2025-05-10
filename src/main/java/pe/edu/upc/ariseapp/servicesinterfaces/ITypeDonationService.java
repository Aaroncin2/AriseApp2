package pe.edu.upc.ariseapp.servicesinterfaces;


import pe.edu.upc.ariseapp.entities.TypeDonation;

import java.util.List;

public interface ITypeDonationService {
    public List<TypeDonation> list();
    public void insert(TypeDonation td);
    public TypeDonation listId(int idTypeDonation);
    public void update(TypeDonation td);
    public void delete(int idTypeDonation);
    public List<String[]> cantidadDonaciones();

}