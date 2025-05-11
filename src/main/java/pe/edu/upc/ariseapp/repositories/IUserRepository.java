package pe.edu.upc.ariseapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.ariseapp.entities.Users;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<Users, Integer> {
    @Query(value = "SELECT u.id_user, u.username, u.email, r.rol\n" +
            "            FROM users u\n" +
            "            JOIN roles r ON u.id_user = r.id_user",nativeQuery = true)
    List<String[]> UsersAndRol();

}
