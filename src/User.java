public class User {
    private static int idCounter = 1;
    private int id;
    private Cpf cpf;
    private String name;
    private int age;
    private String work;

    public User(Cpf cpf, String name, int age, String work) {
        this.cpf = cpf;
        this.name = name;
        validateAge(age);
        this.age = age;
        this.work = work;
        id = idCounter++;
    }

    public int getId() {
        return this.id;
    }

    public void setAge(int age) {
        validateAge(age);
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Cpf getCpf() {
        return this.cpf;
    }

    public boolean hasCpf(Cpf searchCpf) {
        return this.cpf.equals(searchCpf);
    }

    public void setCpf(Cpf newCpf) {
        this.cpf = newCpf;
    }

    private void validateAge(int age) {
        if (age <= 13 || age >= 120) {
            throw new IllegalArgumentException(
                    "Idade inválida, usuário deve ser maior que 13 anos e menor que 120 anos");
        }
    }

    @Override
    public String toString() {
        return "\nId: " + this.id + "\nNome: " + name + "\n" + cpf + "\nIdade: " + age + "\nProfissão: "
                + work + "\n";
    }
}
