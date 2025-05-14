package pe.edu.upc.ariseapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.ariseapp.entities.Comment;

import java.util.List;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, Integer> {
    @Query(value = "SELECT u.username, c.category_comment, c.description_comment\n" +
            "FROM comment c INNER JOIN users u ON u.id_user = c.id_user\n" +
            "WHERE u.username LIKE CONCAT('%', :username, '%')", nativeQuery = true)
    public List<String[]> comentariosByNombreUsuario(@Param("username") String username);

    @Query(value = "SELECT u.username, COUNT(c.id_comment) AS total_comentarios\n" +
            "FROM users u\n" +
            "JOIN comment c ON u.id_user = c.id_user\n" +
            "GROUP BY u.username;", nativeQuery = true)
    public List<String[]> countCommentsByUsers();

}