package repository;
import java.util.List;

import entity.Cpf;
import entity.User;

public interface UserRepository {
    public void addUser(User user);

    public User findUserByCpf(Cpf cpf);

    public List<User> getUsers();

    public void removeUser(User user);

    public boolean isCpfRegistered(Cpf cpf);
}
