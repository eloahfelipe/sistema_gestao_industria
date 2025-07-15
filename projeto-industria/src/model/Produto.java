package model;

public class Produto {

    private Integer idProdutos;
    private String nomeProduto;
    private String descricao;

    public Produto(Integer idProdutos, String nomeProduto, String descricao) {
        this.idProdutos = idProdutos;
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
    }

    public Produto() {

    }

    public Integer getIdProdutos() {
        return idProdutos;
    }

    public void setIdProdutos(Integer idProdutos) {
        this.idProdutos = idProdutos;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    //
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    @Override
    public String toString() {
        return String.format("| %-8d| %-20s | %-100s |",
                idProdutos,  nomeProduto, descricao);
    }
}

