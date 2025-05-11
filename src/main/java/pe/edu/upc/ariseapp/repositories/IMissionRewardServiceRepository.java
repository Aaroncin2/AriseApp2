package pe.edu.upc.ariseapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.ariseapp.entities.MissionReward;

import java.util.List;


@Repository
public interface IMissionRewardServiceRepository extends JpaRepository<MissionReward, Integer> {
    @Query(value = "SELECT id_missions, COUNT(*) AS total_rewards " +
            "FROM mission_reward " +
            "GROUP BY id_missions ", nativeQuery = true)
    List<String[]> findMissionsWithMultipleRewards();
}
