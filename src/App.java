import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);
    static UserService userService = new UserService();

    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("Escolha sua opção");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Mostrar usuário");
            System.out.println("3 - Mostrar Todos os usuários");
            System.out.println("4 - Remover usuário");
            System.out.println("5 - Alterar usuário");
            System.out.println("6 - Sair");

            int scan = Integer.parseInt(scanner.nextLine());
            switch (scan) {
                case 1:
                    while (true) {
                        try {
                            userService.cadastraUsuario();
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 2:
                    userService.mostrarUsuario();
                    break;
                case 3:
                    userService.mostrarUsuarios();
                    break;
                case 4:
                    userService.removerUsuario();
                    break;
                case 5:
                    userService.alterarUsuario();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
    }
}