import dao.SetorDAO;
import menu.SetorMenu;
import model.Setor;
import java.util.ArrayList;
import java.util.Scanner;


public class AppIndustria {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.printf("\n======== MENU PRINCIPAL========");
            System.out.printf("\n[1] Produção");
            System.out.printf("\n[2] Funcionario");
            System.out.printf("\n[3] Setor");
            System.out.printf("\n[4] Produto");
            System.out.printf("\n[5] Relatorio");
            System.out.printf("\n[0] Sair");
            System.out.printf("\nOpção: ");
            Integer opcao = sc.nextInt();

            if(opcao == 0) {
                System.out.printf("Programa finalizado com sucesso.");
                break;
            }

            if(opcao == 3) {
                SetorMenu.main(args);
            }
        }


//        SetorDAO setorDAO = new SetorDAO();
//
//
//        ArrayList<Setor> setores = setorDAO.listar();
////
//        for (Setor setor: setores){
//            System.out.println(setor);
//        }
//
//        System.out.println("+".repeat(100));
//
////        model.Setor setor = new setorDAO.buscarPorId(5);
////        System.out.println(setor);
//
//
////        model.Setor novoSetor = new model.Setor();
////        novoSetor.setIdSetor(31);
////        novoSetor.setNome("Tecnologia");
////        novoSetor.setResponsavel("Carlos");
////
////        Boolean foiAtualizado = setorDAO.atualizar(novoSetor);
////        System.out.println("Foi cadastrado? " + foiAtualizado);
//
////        Boolean foiAtualizado = setorDAO.atualizar(novoSetor);
////        System.out.println("Foi cadastrado? " + foiAtualizado);
//
//
////        Boolean foiCadastrado = setorDAO.cadastrar(novoSetor);
////
////        System.out.println("Foi cadastrado? " + foiCadastrado);
//
//        Boolean foiDeletado = setorDAO.remover(31);
//        System.out.println("Foi deletado? " + foiDeletado);

    }
}
