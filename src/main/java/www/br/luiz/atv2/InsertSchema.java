package www.br.luiz.atv2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class InsertSchema {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("veiculo-jpa");
    EntityManager em = emf.createEntityManager();

    public void Insert() {
        Scanner scan = new Scanner(System.in);
        
        // Abrindo transa��o
        em.getTransaction().begin();

        System.out.println("Digite o chassi do ve�culo: ");
        Integer chassi = scan.nextInt();
        scan.nextLine(); // Limpar o buffer

        System.out.println("Digite o nome do fabricante: ");
        String fabricante = scan.nextLine();

        System.out.println("Digite a descri��o do ve�culo: ");
        String descricao = scan.nextLine();

        System.out.println("Digite a vers�o do ve�culo: ");
        String versao = scan.nextLine();

        System.out.println("Digite o modelo do ve�culo: ");
        String modelo = scan.nextLine();

        System.out.println("Digite o ano do ve�culo: ");
        String ano = scan.nextLine();

        System.out.println("Digite a quantidade do ve�culo: ");
        Integer qtde = scan.nextInt();

        // Criando o novo objeto Veiculo
        Veiculo novoVeiculo = new Veiculo(chassi, fabricante, descricao, versao, modelo, ano, qtde);
        
        // Persistindo o objeto
        em.persist(novoVeiculo);
        em.getTransaction().commit();

        System.out.println("Ve�culo inserido com sucesso!");
        
        // Fechando
        em.close();
        emf.close();
    }
}
