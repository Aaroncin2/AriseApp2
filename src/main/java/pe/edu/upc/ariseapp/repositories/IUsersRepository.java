package pe.edu.upc.ariseapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.ariseapp.entities.Users;

import java.util.List;

@Repository

public interface IUsersRepository extends JpaRepository<Users, Long> {
    public Users findOneByUsername(String username);
}
