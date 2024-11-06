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
        
        // Abrindo transação
        em.getTransaction().begin();

        System.out.println("Digite o chassi do veículo: ");
        Integer chassi = scan.nextInt();
        scan.nextLine(); // Limpar o buffer

        System.out.println("Digite o nome do fabricante: ");
        String fabricante = scan.nextLine();

        System.out.println("Digite a descrição do veículo: ");
        String descricao = scan.nextLine();

        System.out.println("Digite a versão do veículo: ");
        String versao = scan.nextLine();

        System.out.println("Digite o modelo do veículo: ");
        String modelo = scan.nextLine();

        System.out.println("Digite o ano do veículo: ");
        String ano = scan.nextLine();

        System.out.println("Digite a quantidade do veículo: ");
        Integer qtde = scan.nextInt();

        // Criando o novo objeto Veiculo
        Veiculo novoVeiculo = new Veiculo(chassi, fabricante, descricao, versao, modelo, ano, qtde);
        
        // Persistindo o objeto
        em.persist(novoVeiculo);
        em.getTransaction().commit();

        System.out.println("Veículo inserido com sucesso!");
        
        // Fechando
        em.close();
        emf.close();
    }
}
