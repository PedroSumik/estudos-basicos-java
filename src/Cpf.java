public class Cpf {
    private String cpf;

    public Cpf(String cpf) {
        String normalized = normalizeCpf(cpf);
        validateCpf(normalized);
        this.cpf = normalized;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        String normalized = normalizeCpf(cpf);
        validateCpf(normalized);
        this.cpf = normalized;
    }

    private void validateCpf(String cpf) {
        if (!cpf.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF inválido");
        }
    }

    private String normalizeCpf(String cpf) {
        return cpf.replace(".", "").replace("-", "");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Cpf other = (Cpf) obj;
        return cpf.equals(other.cpf);
    }

    @Override
    public String toString() {
        return String.format("CPF: %s.%s.%s-%s", cpf.substring(0, 3), cpf.substring(3, 6), cpf.substring(6, 9),
                cpf.substring(9, 11));
    }
}
