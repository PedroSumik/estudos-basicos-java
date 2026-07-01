import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public User findUserByCpf(Cpf cpf) {
        User userFound = users.stream()
                .filter(u -> u.hasCpf(cpf))
                .findFirst()
                .orElse(null);

        return userFound;
    }

    public boolean isCpfRegistered(Cpf cpf) {
        return users.stream()
                .anyMatch(u -> u.hasCpf(cpf));
    }

    public List<User> getUsers() {
        return users;
    }

    public void removeUser(User user) {
        users.remove(user);
    }
}
