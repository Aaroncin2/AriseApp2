package pe.edu.upc.ariseapp.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.ariseapp.entities.Comment;
import pe.edu.upc.ariseapp.repositories.ICommentRepository;
import pe.edu.upc.ariseapp.servicesinterfaces.ICommentService;

import java.util.List;

@Service
public class CommentServiceImplement implements ICommentService {
    @Autowired
    private ICommentRepository cR;

    @Override
    public List<Comment> list() {return cR.findAll();}

    @Override
    public void insert(Comment co) {
        cR.save(co);
    }

    @Override
    public Comment listId(int idComment) {return cR.findById(idComment).orElse(new Comment());}

    @Override
    public void update(Comment co) {
        cR.save(co);
    }

    @Override
    public void delete(int idComment) {
        cR.deleteById(idComment);
    }

}