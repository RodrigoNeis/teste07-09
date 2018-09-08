package vo;

/**
 * Created by rneis on 07/09/2018.
 */
public class SalesMan extends BasicData {
    private String cpf;
    private String name;
    private double salary;

    public SalesMan(String id, String cpf, String name, double salary) {
        super(id);
        this.cpf = cpf;
        this.name = name;
        this.salary = salary;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SalesMan=[");
        sb.append("id=[").append(getId()).append("]");
        sb.append("cpf=[").append(cpf).append("]");
        sb.append(", name=[").append(name).append("]");
        sb.append(", salary=[").append(salary).append("]");
        sb.append("]");
        return sb.toString();
    }
}
