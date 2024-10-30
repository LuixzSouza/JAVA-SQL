package www.br.luiz.atv2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;
public class UpdateSchema {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("veiculo-jpa");
    EntityManager em = emf.createEntityManager();
    
    public void Update() {
        em.getTransaction().begin();
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o código do veículo que deseja atualizar: ");
        Integer id = scan.nextInt();
        
        Veiculo veiculo = em.find(Veiculo.class, id);
        if (veiculo != null) {
            System.out.println("Digite o novo nome do fabricante: ");
            String novoFabricante = scan.next();
            veiculo.setFabricante(novoFabricante);
            
            // Adicione outras atualizações que desejar
            
            em.merge(veiculo);
            em.getTransaction().commit();
            System.out.println("Veículo atualizado com sucesso!");
        } else {
            System.out.println("Veículo não encontrado.");
        }

        em.close();
        emf.close();
    }
}

