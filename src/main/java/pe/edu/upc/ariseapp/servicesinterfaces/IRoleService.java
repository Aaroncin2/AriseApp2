package pe.edu.upc.ariseapp.servicesinterfaces;

import pe.edu.upc.ariseapp.entities.Role;

import java.util.List;

public interface IRoleService {
    public List<Role> list();
    public void insert(Role role);
    public Role listId(int idRol);
    public void update(Role role);
    public void delete(int idRol);
}
