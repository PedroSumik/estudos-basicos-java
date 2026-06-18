import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

    Scanner scanner = new Scanner(System.in);
    List<User> users = new ArrayList<>();

    public void cadastraUsuario() {
        System.out.println("Digite o cpf do usuário:");
        String cpf = scanner.nextLine();
        while (!UserValidator.isValidCpf(cpf, users)) {
            System.out.println("Digite o cpf do usuário:");
            cpf = scanner.nextLine();
        }

        System.out.println("Digite o nome do usuário:");
        String name = scanner.nextLine();

        System.out.println("Digite a idade do usuário");
        int age = Integer.parseInt(scanner.nextLine());
        while (!UserValidator.isValidAge(age)) {
            System.out.println("Digite a idade do usuário");
            age = Integer.parseInt(scanner.nextLine());
        }

        System.out.println("Digite a profissão do usuário");
        String work = scanner.nextLine();

        users.add(new User(cpf, name, age, work));
        System.out.println("Usuário cadastrado com sucesso!");
    }

    public void mostrarUsuario() {
        if (users.isEmpty()) {
            System.out.println("---------------------");
            System.out.println("Nenhum usuário cadastrado.");
            System.out.println("---------------------");
            return;
        }
        System.out.println("Digite o CPF do usuário que deseja mostrar:");
        String cpfFiltrado = scanner.nextLine();
        User userFound = buscarUsuarioPorCpf(cpfFiltrado);

        if (userFound == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }
        System.out.println(userFound);
    }

    public void mostrarUsuarios() {
        if (users.isEmpty()) {
            System.out.println("---------------------");
            System.out.println("Nenhum usuário cadastrado.");
            System.out.println("---------------------");
            return;
        }
        users.forEach(u -> {
            System.out.println("\n");
            System.out.println(u);
            System.out.println("-------------------");
        });
    }

    public void removerUsuario() {
        if (users.isEmpty()) {
            System.out.println("---------------------");
            System.out.println("Nenhum usuário cadastrado.");
            System.out.println("---------------------");
            return;
        }
        System.out.println("Digite o CPF do usuário que deseja remover:");
        String cpfFiltrado = scanner.nextLine();
        User userFound = buscarUsuarioPorCpf(cpfFiltrado);

        if (userFound == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }
        users.remove(userFound);
        System.out.println("Usuário removido com sucesso!");
    }

    public void alterarUsuario() {
        if (users.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }
        System.out.println("Digite o CPF do usuário que deseja alterar:");
        String cpfFiltrado = scanner.nextLine();
        User userFound = buscarUsuarioPorCpf(cpfFiltrado);

        if (userFound == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }
        System.out.println("O que deseja alterar?");
        System.out.println("1 - Nome");
        System.out.println("2 - CPF");
        System.out.println("3 - Idade");
        System.out.println("4 - Profissão");
        System.out.println("5 - Voltar");
        int opcao = Integer.parseInt(scanner.nextLine());
        switch (opcao) {
            case 1:
                alterarNome(userFound);
                break;
            case 2:
                alterarCpf(userFound);
                break;
            case 3:
                alterarIdade(userFound);
                break;
            case 4:
                alterarProfissao(userFound);
                break;
            case 5:
                break;
            default:
                System.out.println("Opção inválida, tente novamente.");
                return;
        }
        System.out.println("Usuário alterado com sucesso!");

    }

    public void alterarProfissao(User user) {
        System.out.println("Digite a nova profissão do usuário:");
        String work = scanner.nextLine();
        user.setWork(work);
    }

    public void alterarIdade(User user) {
        System.out.println("Digite a nova idade do usuário:");
        int age = Integer.parseInt(scanner.nextLine());
        while (!UserValidator.isValidAge(age)) {
            System.out.println("Digite a nova idade do usuário:");
            age = Integer.parseInt(scanner.nextLine());
        }
        user.setAge(age);
    }

    public void alterarCpf(User user) {
        System.out.println("Digite o novo CPF do usuário:");
        String cpf = scanner.nextLine();
        while (!UserValidator.isValidCpf(cpf, users)) {
            System.out.println("Digite o novo CPF do usuário:");
            cpf = scanner.nextLine();
        }
        user.setCpf(cpf);
    }

    public void alterarNome(User user) {
        System.out.println("Digite o novo nome do usuário:");
        String name = scanner.nextLine();
        user.setName(name);
    }

    public User buscarUsuarioPorCpf(String cpf) {
        return users.stream().filter(u -> cpf.equals(u.getCpf()))
                .findFirst().orElse(null);
    }
}
