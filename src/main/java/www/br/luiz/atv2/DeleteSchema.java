package www.br.luiz.atv2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class DeleteSchema {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("veiculo-jpa");
    EntityManager em = emf.createEntityManager();

    public void Deletar() {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Digite o codigo do veiculo que deseja deletar: ");
        Integer id = scan.nextInt();
        
        // Abrindo transação
        em.getTransaction().begin();
        
        Veiculo veiculo = em.find(Veiculo.class, id);
        
        if (veiculo != null) {
            em.remove(veiculo);
            em.getTransaction().commit();
            System.out.println("Veiculo deletado com sucesso!");
        } else {
            em.getTransaction().rollback();
            System.out.println("Veiculo não encontrado. Não foi possivel deletar.");
        }

        // Fechando
        em.close();
        emf.close();
    }
}
