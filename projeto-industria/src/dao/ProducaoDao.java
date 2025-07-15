package dao;

import config.ConexaoMySQL;
import model.Funcionario;
import model.Producao;
import model.Produto;
import model.Setor;

import java.sql.*;
import java.util.ArrayList;

public class ProducaoDao {
    private static Connection conn = ConexaoMySQL.getConnection();

    public ArrayList<Producao> listar() {
        ArrayList<Producao> producoes = new ArrayList<>();
        try {
            String sql = "SELECT p.id_producao, p.data_producao, p.quantidade, " +
                    "prod.id_produtos, prod.nome_produto, prod.descricao, " +
                    "f.id_funcionario, f.nome, f.sobrenome, " +
                    "s.id_setor, s.nome_setor, s.responsavel " +
                    "FROM producao p " +
                    "INNER JOIN produtos prod ON p.id_produtos = prod.id_produtos " +
                    "INNER JOIN funcionario f ON p.id_funcionario = f.id_funcionario " +
                    "INNER JOIN setor s ON f.id_setor = s.id_setor;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // model.Setor
                Setor setor = new Setor(
                        rs.getInt("id_setor"),
                        rs.getString("nome_setor"),
                        rs.getString("responsavel")
                );

                // model.Funcionario
                Funcionario funcionario = new Funcionario(
                        rs.getInt("id_funcionario"),
                        rs.getString("nome"),
                        rs.getString("sobrenome"),
                        setor
                );

                // model.Produto
                Produto produto = new Produto(
                        rs.getInt("id_produtos"),
                        rs.getString("nome_produto"),
                        rs.getString("descricao")
                );

                // model.Producao
                Producao producao = new Producao(
                        rs.getInt("id_producao"),
                        produto,
                        funcionario,
                        rs.getString("data_producao"),
                        rs.getInt("quantidade")
                );

                producoes.add(producao);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar produções: " + e.getMessage());
        }

        return producoes;
    }

    public Producao buscarPorId(Integer id) {
        try {
            String sql = "SELECT p.id_producao, p.data_producao, p.quantidade, " +
                    "prod.id_produtos, prod.nome_produto, prod.descricao, " +
                    "f.id_funcionario, f.nome, f.sobrenome, " +
                    "s.id_setor, s.nome_setor, s.responsavel " +
                    "FROM producao p " +
                    "INNER JOIN produtos prod ON p.id_produtos = prod.id_produtos " +
                    "INNER JOIN funcionario f ON p.id_funcionario = f.id_funcionario " +
                    "INNER JOIN setor s ON f.id_setor = s.id_setor " +
                    "WHERE p.id_producao = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Setor setor = new Setor(
                        rs.getInt("id_setor"),
                        rs.getString("nome_setor"),
                        rs.getString("responsavel")
                );

                Funcionario funcionario = new Funcionario(
                        rs.getInt("id_funcionario"),
                        rs.getString("nome"),
                        rs.getString("sobrenome"),
                        setor
                );

                Produto produto = new Produto(
                        rs.getInt("id_produtos"),
                        rs.getString("nome_produto"),
                        rs.getString("descricao")
                );

                return new Producao(
                        rs.getInt("id_producao"),
                        produto,
                        funcionario,
                        rs.getString("data_producao"),
                        rs.getInt("quantidade")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar produção por ID: " + e.getMessage());
        }

        return null;
    }

    public Boolean cadastrar(Producao producao) {
        try {
            String sql = "INSERT INTO producao (id_produtos, id_funcionario, data_producao, quantidade) " +
                    "VALUES (?, ?, ?, ?);";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, producao.getProdutos().getIdProdutos());
            ps.setInt(2, producao.getFuncionario().getIdFuncionario());
            ps.setString(3, producao.getDataProducao());
            ps.setInt(4, producao.getQuantidade());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar produção: " + e.getMessage());
        }

        return false;
    }

    public Boolean atualizar(Producao producao) {
        try {
            String sql = "UPDATE producao SET id_produtos = ?, id_funcionario = ?, data_producao = ?, quantidade = ? " +
                    "WHERE id_producao = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, producao.getProdutos().getIdProdutos());
            ps.setInt(2, producao.getFuncionario().getIdFuncionario());
            ps.setString(3, producao.getDataProducao());
            ps.setInt(4, producao.getQuantidade());
            ps.setInt(5, producao.getIdProducao());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar produção: " + e.getMessage());
        }

        return false;
    }

    public Boolean remover(Integer id) {
        try {
            Producao producao = buscarPorId(id);
            if (producao == null) return false;

            String sql = "DELETE FROM producao WHERE id_producao = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao remover produção: " + e.getMessage());
        }

        return false;
    }
}


