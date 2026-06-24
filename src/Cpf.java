public class Cpf {
    private String cpf;

    public Cpf(String cpf) {
        if (!isValidCpf(cpf)) {
            throw new IllegalArgumentException("CPF inválido");
        }
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (!isValidCpf(cpf)) {
            throw new IllegalArgumentException("CPF inválido");
        }
        this.cpf = cpf;
    }

    private boolean isValidCpf(String cpf) {
        String normalized = cpf.replace(".", "").replace("-", "");
        if (!normalized.matches("\\d{11}")) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "CPF: " + cpf;
    }
}
