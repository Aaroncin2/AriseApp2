package pe.edu.upc.ariseapp.servicesinterfaces;

import pe.edu.upc.ariseapp.entities.Users;

import java.util.List;

public interface IUserService {
    public List<Users> list();
    public void insert(Users u);
    public Users listId(int idUser);
    public void update(Users u);
    public void delete(int idUser);
}
