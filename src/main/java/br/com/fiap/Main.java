package br.com.fiap;

import br.com.fiap.domain.entity.Advogado;
import br.com.fiap.domain.entity.Estado;
import br.com.fiap.domain.entity.Processo;
import br.com.fiap.domain.entity.TipoDeAcao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle");
        EntityManager manager = factory.createEntityManager();

//        salvarProcesso(manager);

        // Atalho Eclipse ALT SHIFT M para transformar em um metodo
//        findById(manager);

        List<Processo> list = manager.createQuery("SELECT p FROM Processo p").getResultList();
        list.forEach(System.out::println);


        manager.close();
        factory.close();
    }


    private static void salvarProcesso(EntityManager manager) {
        TipoDeAcao tipoAcao = new TipoDeAcao(null, "Tipo");
        Estado estado = new Estado(null, "São Paulo", "SP");
        Advogado advogado = new Advogado(null, "Nome", "NumeroOAB", estado);
        Processo processo = new Processo(null, "123456", true, advogado, tipoAcao);

        manager.getTransaction().begin();
        manager.persist(processo);
        manager.getTransaction().commit();
    }

    private static void findById(EntityManager manager) {
        Long id = Long.valueOf(JOptionPane.showInputDialog("Informe o ID do processo: "));
        Processo processo1 = manager.find(Processo.class, id);
        System.out.println(processo1);
    }
}