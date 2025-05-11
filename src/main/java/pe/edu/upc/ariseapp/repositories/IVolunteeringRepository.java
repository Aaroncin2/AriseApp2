package pe.edu.upc.ariseapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.ariseapp.entities.Volunteering;

import java.util.List;


@Repository
public interface IVolunteeringRepository extends JpaRepository<Volunteering, Integer> {
    @Query(value = "select v.id_volunteering, v.name_volunteering, v.activity_volunteering, u.username, v.attendance_volunteering\n" +
            "FROM volunteerings v INNER JOIN rols r ON v.id_rol = r.id_rol INNER JOIN users u ON u.id_user = r.id_user\n" +
            "WHERE attendance_volunteering = true order by v.id_volunteering desc", nativeQuery = true)
    public List<String[]> userAttendance();
}
