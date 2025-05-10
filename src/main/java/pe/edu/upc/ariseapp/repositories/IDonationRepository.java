package pe.edu.upc.ariseapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.ariseapp.entities.Donation;


@Repository
public interface IDonationRepository extends JpaRepository<Donation, Integer> {
}
