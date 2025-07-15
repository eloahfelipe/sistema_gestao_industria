package file;

import dao.SetorDAO;
import model.Setor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EscritaArquivo {
    public static void main(String[] args) {
        String caminho = "src/file/novo_arquivo.csv";
        File arquivo = new File(caminho);
        SetorDAO setorDAO = new SetorDAO();
        ArrayList<Setor> setores =  setorDAO.listar();

        try (BufferedWriter bw = new BufferedWriter((new FileWriter(arquivo)))) {

//            bw.write("Eu adoro codar em JAVA");
//            bw.newLine();
//            bw.write("Java é a melhor linguagem do mundo.");

//            for (Setor setor : setores){
//                bw.write(setor.toString());
//                bw.newLine();
//            }

            for (Setor setor : setores) {
                bw.write(setor.getIdSetor() + "," + setor.getNomeSetor() + "," + setor.getResponsavel());
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Erro ao escrever o arquivo");


        }
    }
}
