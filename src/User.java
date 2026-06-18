public class User {
    private static int idCounter = 1;
    private int id;
    private String cpf;
    private String name;
    private int age;
    private String work;

    public User(String cpf, String name, int age, String work) {
        this.cpf = cpf;
        this.name = name;
        this.age = age;
        this.work = work;
        id = idCounter;
        User.idCounter++;
    }

    public int getId() {
        return this.id;
    }

    public void setAge(int age) {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + "\nNome: " + name + "\nCPF: " + cpf + "\nIdade: " + age + "\nProfissão: "
                + work;
    }
}
