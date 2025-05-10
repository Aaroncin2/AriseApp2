package pe.edu.upc.ariseapp.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.ariseapp.entities.Role;
import pe.edu.upc.ariseapp.repositories.IRoleRepository;
import pe.edu.upc.ariseapp.servicesinterfaces.IRoleService;

import java.util.List;
@Service
public class RolServiceImplement implements IRoleService {
    @Autowired
    private IRoleRepository rR;

    @Override
    public List<Role> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Role role) {
        rR.save(role);
    }

    @Override
    public Role listId(int idRol) {return rR.findById(idRol).orElse(new Role());}

    @Override
    public void update(Role role) {
        rR.save(role);
    }

    @Override
    public void delete(int idRol) {
        rR.deleteById(idRol);
    }
}
