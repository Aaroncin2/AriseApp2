package pe.edu.upc.ariseapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.ariseapp.entities.Mission;

import java.util.List;

public interface IMissionRepository extends JpaRepository<Mission, Integer> {
    @Query(value = "SELECT COUNT(m.id_mission) FROM mission m",nativeQuery = true)
    List<String[]> missionsByUser();
}
