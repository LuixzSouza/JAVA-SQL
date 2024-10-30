package www.br.luiz.atv2;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindSchema {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("veiculo-jpa");
    EntityManager em = emf.createEntityManager();

    public void Find() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o código do veículo que deseja encontrar: ");
        Integer id = scan.nextInt();

        // Abrindo transação
        em.getTransaction().begin();
        
        Veiculo veiculo = em.find(Veiculo.class, id);
        
        if (veiculo != null) {
            System.out.println("Veículo encontrado: " + veiculo.toString());
        } else {
            System.out.println("Veículo não encontrado.");
        }
        
        em.getTransaction().commit();

        // Fechando
        em.close();
        emf.close();
    }
}
