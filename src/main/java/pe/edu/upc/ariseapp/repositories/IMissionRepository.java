package pe.edu.upc.ariseapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.ariseapp.entities.Mission;

import java.util.List;

public interface IMissionRepository extends JpaRepository<Mission, Integer> {
    @Query(value = "SELECT u.name_user, COUNT(m.id_missions) AS total_misiones\n" +
            "FROM users u\n" +
            "JOIN missions m ON u.id_user = m.id_user\n" +
            "GROUP BY u.name_user",nativeQuery = true)
    List<String[]> missionsByUser();
}
