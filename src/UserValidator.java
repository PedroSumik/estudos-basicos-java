import java.util.List;

public class UserValidator {
    public static boolean isValidCpf(String cpf, List<User> users) {
        if (cpf == null || !cpf.matches("\\d{11}")) {
            System.out.println("CPF invalido, deve conter 11 dígitos numéricos.");
            return false;
        }
        if (users.stream().anyMatch(u -> cpf.equals(u.getCpf()))) {
            System.out.println("CPF já cadastrado, tente novamente.");
            return false;
        }
        return true;
    }

    public static boolean isValidAge(int age) {
        if (age <= 13 || age >= 120) {
            System.out.println("Idade inválida, usuário deve ser maior que 13 anos");
            return false;
        }
        return true;
    }
}
