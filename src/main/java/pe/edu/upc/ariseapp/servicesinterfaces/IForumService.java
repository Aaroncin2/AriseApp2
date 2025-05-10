package pe.edu.upc.ariseapp.servicesinterfaces;

import pe.edu.upc.ariseapp.entities.Forum;

import java.util.List;

public interface IForumService {
    public List<Forum> list();
    public void insert(Forum f);
    public Forum listId(int idForum);
    public void update(Forum f);
    public void delete(int idForum);
}
