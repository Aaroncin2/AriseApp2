package pe.edu.upc.ariseapp.servicesinterfaces;

import pe.edu.upc.ariseapp.entities.Comment;

import java.util.List;

public interface ICommentService {
    public List<Comment> list();
    public void insert(Comment co);
    public Comment listId(int idComment);
    public void update(Comment co);
    public void delete(int idComment);
}