import controller.Menu;
import repository.MemoryUserRepository;
import repository.UserRepository;
import service.UserServiceImpl;

public class App {
    private static final UserRepository repository = new MemoryUserRepository();
    private static final UserServiceImpl userService = new UserServiceImpl(repository);

    public static void main(String[] args) throws Exception {
        Menu menu = new Menu(userService);
        menu.start();
    }
}