package pe.edu.upc.ariseapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.ariseapp.entities.Forum;

import java.util.List;

@Repository
public interface IForumRepository extends JpaRepository<Forum, Integer> {
    @Query(value = "SELECT u.username, f.content_forum, c.description_comment\n" +
            "FROM comment c\n" +
            "JOIN forum f ON c.id_forum = f.id_forum\n" +
            "JOIN users u ON c.id_user = u.id_user;", nativeQuery = true)
    public List<String[]> forumsxComment();
}
