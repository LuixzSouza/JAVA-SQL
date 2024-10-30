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

        System.out.println("Digite o c�digo do ve�culo que deseja encontrar: ");
        Integer id = scan.nextInt();

        // Abrindo transa��o
        em.getTransaction().begin();
        
        Veiculo veiculo = em.find(Veiculo.class, id);
        
        if (veiculo != null) {
            System.out.println("Ve�culo encontrado: " + veiculo.toString());
        } else {
            System.out.println("Ve�culo n�o encontrado.");
        }
        
        em.getTransaction().commit();

        // Fechando
        em.close();
        emf.close();
    }
}
