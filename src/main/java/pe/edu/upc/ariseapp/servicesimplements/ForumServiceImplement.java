package pe.edu.upc.ariseapp.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.ariseapp.entities.Forum;
import pe.edu.upc.ariseapp.repositories.IForumRepository;
import pe.edu.upc.ariseapp.servicesinterfaces.IForumService;

import java.util.List;

@Service
public class ForumServiceImplement implements IForumService {
    @Autowired
    private IForumRepository fR;

    @Override
    public List<Forum> list() {return fR.findAll();}

    @Override
    public void insert(Forum f) {
        fR.save(f);
    }

    @Override
    public Forum listId(int idForum) {return fR.findById(idForum).orElse(new Forum());}

    @Override
    public void update(Forum f) {
        fR.save(f);
    }

    @Override
    public void delete(int idForum) {fR.deleteById(idForum);}

    @Override
    public List<String[]> forumsxComment() {
        return fR.forumsxComment();
    }

    @Override
    public List<String[]> userxForum() {
        return fR.userxForum();
    }
}
