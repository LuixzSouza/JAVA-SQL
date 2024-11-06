package www.br.luiz.atv2;

import java.util.Scanner;

public class InputUsuario {
    public String nomeCliente;
    public int choice;
    
    Scanner scan = new Scanner(System.in);
    
    public void PerguntarNome() {
        System.out.println("Qual seu nome: ");
        nomeCliente = scan.nextLine();
    }
    
    public void EscolhaSchema() {
        DeleteSchema del = new DeleteSchema();
        FindSchema find = new FindSchema();
        InsertSchema insert = new InsertSchema();
        UpdateSchema update = new UpdateSchema();

        System.out.println(nomeCliente + ", escolha: 1-inserir, 2-encontrar, 3-deletar, 4-atualizar");
        choice = scan.nextInt(); // Lê a escolha do usuário

        switch(choice) {
            case 1:
                insert.Insert();
                break;
            case 2:
                find.Find();
                break;
            case 3:
                del.Deletar();
                break;
            case 4:
                update.Update();
                break;
            default:
                System.out.println("Opção Inválida");
        }
    }
}
