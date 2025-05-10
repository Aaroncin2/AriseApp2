package pe.edu.upc.ariseapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.ariseapp.entities.Mission;

public interface IMissionRepository extends JpaRepository<Mission, Integer> {
}
