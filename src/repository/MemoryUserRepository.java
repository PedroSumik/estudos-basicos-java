package repository;
import java.util.ArrayList;
import java.util.List;

import entity.Cpf;
import entity.User;

public class MemoryUserRepository implements UserRepository {
    List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public User findUserByCpf(Cpf cpf) {
        User userFound = users.stream()
                .filter(u -> u.hasCpf(cpf))
                .findFirst()
                .orElse(null);

        return userFound;
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public void removeUser(User user) {
        users.remove(user);
    }

    @Override
    public boolean isCpfRegistered(Cpf cpf) {
        return users.stream()
                .anyMatch(u -> u.hasCpf(cpf));
    }

}
