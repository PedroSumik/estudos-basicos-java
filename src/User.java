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
        if (!isAgeValid(age)) {
            throw new IllegalArgumentException("Idade inválida, usuário deve ser maior que 13 anos");
        }
        this.age = age;
        this.work = work;
        id = idCounter;
        User.idCounter++;
    }

    public int getId() {
        return this.id;
    }

    public void setAge(int age) {
        if (!isAgeValid(age)) {
            throw new IllegalArgumentException("Idade inválida, usuário deve ser maior que 13 anos");
        }
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

    public boolean hasCpf(String cpf) {
        return this.cpf.getCpf().equals(cpf);
    }

    public boolean isAgeValid(int age) {
        if (age <= 13 || age >= 120) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + "\nNome: " + name + "\n" + cpf + "\nIdade: " + age + "\nProfissão: "
                + work;
    }
}
