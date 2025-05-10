package pe.edu.upc.ariseapp.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.ariseapp.entities.TypeDonation;
import pe.edu.upc.ariseapp.repositories.ITypeDonationRepository;
import pe.edu.upc.ariseapp.servicesinterfaces.ITypeDonationService;

import java.util.List;

@Service
public class TypeDonationServiceImplement implements ITypeDonationService {
    @Autowired
    private ITypeDonationRepository tR;

    @Override
    public List<TypeDonation> list() {return tR.findAll();}

    @Override
    public void insert(TypeDonation td) {
        tR.save(td);
    }

    @Override
    public TypeDonation listId(int idTypeDonation) {return tR.findById(idTypeDonation).orElse(new TypeDonation());}

    @Override
    public void update(TypeDonation td) {
        tR.save(td);
    }

    @Override
    public void delete(int idTypeDonation) {
        tR.deleteById(idTypeDonation);
    }

    @Override
    public List<String[]> cantidadDonaciones(){ return tR.cantidadDonaciones();};
}