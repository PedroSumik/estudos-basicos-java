package controller;
import java.util.Scanner;

import service.UserService;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    private final UserService userService;

    public Menu(UserService service) {
        this.userService = service;
    }

    public void start() {
        while (true) {
            showMenu();
            int scan = Integer.parseInt(scanner.nextLine());
            handleOption(scan);
        }
    }

    public void showMenu() {
        System.out.println("Escolha sua opção");
        System.out.println("1 - Cadastrar usuário");
        System.out.println("2 - Mostrar usuário");
        System.out.println("3 - Mostrar Todos os usuários");
        System.out.println("4 - Remover usuário");
        System.out.println("5 - Alterar usuário");
        System.out.println("6 - Sair");
    }

    public void handleOption(int option) {
        switch (option) {
            case 1:
                userService.addUser();
                break;
            case 2:
                userService.showUser();
                break;
            case 3:
                userService.showUsers();
                break;
            case 4:
                userService.removeUser();
                break;
            case 5:
                userService.updateUser();
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
