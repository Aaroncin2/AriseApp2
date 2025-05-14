package pe.edu.upc.ariseapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.ariseapp.entities.Campaign;

import java.util.List;

@Repository
public interface ICampaignRepository extends JpaRepository<Campaign, Integer> {
    @Query(value = "SELECT c.id_campaign, c.name_campaign, c.description_campaign, u.username, r.rol\n" +
            "FROM campaign c\n" +
            "INNER JOIN roles r ON c.id_rol = r.id_rol\n" +
            "INNER JOIN users u on r.id_user = u.id_user", nativeQuery = true)
    List<String[]> findCampaignsByUserAndRol();
}
