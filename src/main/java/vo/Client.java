package vo;

/**
 * Created by rneis on 07/09/2018.
 */
public class Client extends BasicData {
    private String cnpj;
    private String name;
    private String businessArea;

    public Client(String id, String cnpj, String name, String businessArea) {
        super(id);
        this.cnpj = cnpj;
        this.name = name;
        this.businessArea = businessArea;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Client=[");
        sb.append("id=[").append(getId()).append("]");
        sb.append("name=[").append(name).append("]");
        sb.append(", cnpj=[").append(cnpj).append("]");
        sb.append(", businessArea=[").append(businessArea).append("]");
        sb.append("]");
        return sb.toString();
    }
}
