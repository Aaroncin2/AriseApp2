package pe.edu.upc.ariseapp.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.upc.ariseapp.entities.Users;
import pe.edu.upc.ariseapp.repositories.IUserRepository;
import pe.edu.upc.ariseapp.servicesinterfaces.IUserService;

import java.util.List;

@Service
public class UserServiceImplement implements IUserService {
    @Autowired
    private IUserRepository uR;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Users> list() {
        return uR.findAll();
    }

    @Override
    public void insert(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        uR.save(user);
    }

    @Override
    public Users listId(int idUser) {
        return uR.findById(idUser).orElse(new Users());
    }

    @Override
    public void update(Users user) {
        uR.save(user);
    }

    @Override
    public void delete(int idUser) {
        uR.deleteById(idUser);
    }

    @Override
    public List<String[]> UsersAndRol() {
        return uR.UsersAndRol();
    }
}
