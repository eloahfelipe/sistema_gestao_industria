package dao;

import config.ConexaoMySQL;
import model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class produtoDao {
    private static Connection conn = ConexaoMySQL.getConnection();

    public ArrayList<Produto> listar() {
        try {
            ArrayList<Produto> produtos = new ArrayList<>();
            String sql = "SELECT * FROM produtos;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id_produtos");
                String nome = rs.getString("nome_produto");
                String responsavel = rs.getString("descricao");

                produtos.add(new Produto(id, nome, responsavel));

            }
            return produtos;

        } catch (SQLException e) {
            System.out.println("Erro ao listar os Produtos" + e.getMessage());
        }

        return null;
    }

    public Produto buscarPorId(Integer id){
        try {
            String sql = "SELECT * FROM produtos WHERE id_produtos = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();


            if(rs.next()){

                Integer idProduto = rs.getInt("id_produtos");
                String nome = rs.getString("nome_produto");
                String descricao = rs.getString("descricao");

                Produto produto = new Produto(idProduto,nome,descricao);
                return produto;

            }


        }catch (SQLException e){
            System.out.println("Erro ao buscar o produto pelo ID."+ e.getMessage());
        }

        return null;
    }

    public static Boolean cadastrar(Produto produto){
        try{
            String sql = "INSERT INTO produtos (nome_produto, descricao) VALUES(?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, produto.getNomeProduto());
            ps.setString(2, produto.getDescricao());;
            int qtdlinha = ps.executeUpdate();

            if (qtdlinha > 0 ){
                return true;
            }
            return  false;


        }catch (SQLException e){
            System.out.println("Erro ao cadatrar produto"+e.getMessage());
        }
        return null;

    }

    public static Boolean atualizar(Produto produto){
        try {
            String sql = "UPDATE produtos SET nome_produto = ?,descricao = ? WHERE id_produtos = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,produto.getNomeProduto());
            ps.setString(2, produto.getDescricao());;
            ps.setInt(3,produto.getIdProdutos());
            int qtdAtualizacoes = ps.executeUpdate();

            if (qtdAtualizacoes > 0){
                return true;
            }
            return false;

        }catch (SQLException e){
            System.out.println("Erro ao atualizar o model.Produto."+e.getMessage());
        }

        return false;

    }

    public Boolean remover(Integer id){
        try {
            String sql = "DELETE  FROM produtos WHERE id_produtos = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);

            Produto produtoRetornado = buscarPorId(id);


            int qtddelete = ps.executeUpdate();
            if (produtoRetornado != null)
            {
                ps.executeUpdate();
                return true;
            }
            return false;

        }catch (SQLException e){
            System.out.println("Erro ao deletar o produto "+e.getMessage());
        }


        return false;

    }

}