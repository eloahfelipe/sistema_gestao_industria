package model;

public class Producao {

    private Integer idProducao;
    private Produto produtos;
    private Funcionario funcionario;
    private String dataProducao;
    private Integer quantidade;


    public Producao(Integer idProducao, Produto produtos, Funcionario funcionario, String dataProducao, Integer quantidade) {
        this.idProducao = idProducao;
        this.produtos = produtos;
        this.funcionario = funcionario;
        this.dataProducao = dataProducao;
        this.quantidade = quantidade;
    }

    public Producao() {

    }

    public Integer getIdProducao() {
        return idProducao;
    }

    public void setIdProducao(Integer idProducao) {
        this.idProducao = idProducao;
    }

    public Produto getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto produtos) {
        this.produtos = produtos;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getDataProducao() {
        return dataProducao;
    }

    public void setDataProducao(String dataProducao) {
        this.dataProducao = dataProducao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

//    @Override
//    public String toString() {
//        return "{" +
//                "\"idProducao\": " + idProducao + "," +
//                "\"produtos\": " + produtos + "," +
//                "\"funcionario\": " + funcionario + "," +
//                "\"dataProducao\": \"" + dataProducao + "\"," +
//                "\"quantidade\": " + quantidade +
//                "}";
    //  }

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    @Override
    public String toString() {
        return String.format("| %-8d | %-20s | %-20s |%-15s |%-10s |",
                idProducao, produtos, funcionario, dataProducao, quantidade);
    }
}
