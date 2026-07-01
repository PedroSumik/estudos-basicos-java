import java.util.List;
import java.util.Scanner;

public class UserService {

    Scanner scanner = new Scanner(System.in);
    UserRepository userRepository = new UserRepository();

    public void addUser() {
        System.out.println("Digite o cpf do usuário:");
        String cpfInput = scanner.nextLine();
        Cpf cpf = new Cpf(cpfInput);

        if (userRepository.isCpfRegistered(cpf)) {
            throw new IllegalArgumentException("CPF já cadastrado");
        }

        System.out.println("Digite o nome do usuário:");
        String name = scanner.nextLine();

        System.out.println("Digite a idade do usuário");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("Digite a profissão do usuário");
        String work = scanner.nextLine();

        userRepository.addUser(new User(cpf, name, age, work));
        System.out.println("Usuário cadastrado com sucesso!");
    }

    public void showUser() {
        if (emptyList())
            return;
        System.out.println("Digite o CPF do usuário que deseja mostrar:");
        String filteredCpf = scanner.nextLine();
        Cpf cpf = new Cpf(filteredCpf);
        User userFound = userRepository.findUserByCpf(cpf);

        if (userFound == null) {
            System.out.println("---------------------\nNenhum usuário cadastrado.\n---------------------");
            return;
        }
        System.out.println(userFound);
    }

    public void showUsers() {
        if (emptyList())
            return;

        List<User> users = userRepository.getUsers();
        users.forEach(u -> {
            System.out.println(u);
        });
    }

    public void removeUser() {
        if (emptyList())
            return;
        System.out.println("Digite o CPF do usuário que deseja remover:");
        String filteredCpf = scanner.nextLine();
        Cpf cpf = new Cpf(filteredCpf);
        User userFound = userRepository.findUserByCpf(cpf);

        if (userFound == null) {
            System.out.println("---------------------\nNenhum usuário cadastrado.\n---------------------");
            return;
        }
        userRepository.removeUser(userFound);
        System.out.println("Usuário removido com sucesso!");
    }

    public void updateUser() {
        if (emptyList())
            return;
        System.out.println("Digite o CPF do usuário que deseja alterar:");
        String filteredCpf = scanner.nextLine();
        Cpf cpf = new Cpf(filteredCpf);
        User userFound = userRepository.findUserByCpf(cpf);

        if (userFound == null) {
            System.out.println("---------------------\nNenhum usuário cadastrado.\n---------------------");
            return;
        }
        System.out.println("O que deseja alterar?");
        System.out.println("1 - Nome");
        System.out.println("2 - CPF");
        System.out.println("3 - Idade");
        System.out.println("4 - Profissão");
        System.out.println("5 - Voltar");
        int option = Integer.parseInt(scanner.nextLine());
        switch (option) {
            case 1:
                updateName(userFound);
                break;
            case 2:
                updateCpf(userFound);
                break;
            case 3:
                updateAge(userFound);
                break;
            case 4:
                updateWork(userFound);
                break;
            case 5:
                break;
            default:
                System.out.println("Opção inválida, tente novamente.");
                return;
        }
        System.out.println("Usuário alterado com sucesso!");

    }

    public void updateWork(User user) {
        System.out.println("Digite a nova profissão do usuário:");
        String work = scanner.nextLine();
        user.setWork(work);
    }

    public void updateAge(User user) {
        System.out.println("Digite a nova idade do usuário:");
        int age = Integer.parseInt(scanner.nextLine());
        user.setAge(age);
    }

    public void updateCpf(User user) {
        System.out.println("Digite o novo CPF do usuário:");
        String cpfFiltrado = scanner.nextLine();
        Cpf cpf = new Cpf(cpfFiltrado);
        if (userRepository.isCpfRegistered(cpf)) {
            throw new IllegalArgumentException("CPF já cadastrado");
        }

        user.setCpf(cpf);
    }

    public void updateName(User user) {
        System.out.println("Digite o novo nome do usuário:");
        String name = scanner.nextLine();
        user.setName(name);
    }

    private boolean emptyList() {
        if (userRepository.getUsers().isEmpty()) {
            System.out.println("---------------------\nNenhum usuário cadastrado.\n---------------------");
            return true;
        }
        return false;
    }
}
