package pe.edu.upc.ariseapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.ariseapp.entities.TypeDonation;

import java.util.List;

@Repository
public interface ITypeDonationRepository extends JpaRepository<TypeDonation, Integer> {
    @Query(value = "select type_donation, count(id_donation) FROM typedonation group by type_donation", nativeQuery = true)
    public List<String[]> cantidadDonaciones();
}
