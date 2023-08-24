package br.com.fiap;

import br.com.fiap.domain.entity.Advogado;
import br.com.fiap.domain.entity.Estado;
import br.com.fiap.domain.entity.Processo;
import br.com.fiap.domain.entity.TipoDeAcao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        Estado estado = new Estado();
        estado.setNome("São Paulo").setSigla("SP");

        TipoDeAcao tpAcao = new TipoDeAcao();
        tpAcao.setNome("Ação Ordinária");

        Advogado adv = new Advogado();
        adv.setNome("Igor").setEstado(estado).setNumeroOAB("UF999999");

        Processo processo = new Processo();
        processo.setAdvogado(adv).setNumero("1").setProBono(true).setTipoDeAcao(tpAcao);


        EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();

        manager.persist(estado);
        manager.persist(tpAcao);
        manager.persist(adv);
        manager.persist(processo);

        manager.getTransaction().commit();


//        Processo consultaProcesso = consultaProcesso(1L, manager);
//        System.out.println("Consulta processo: " + consultaProcesso);

        manager.close();
        factory.close();
    }

    public static Processo consultaProcesso (Long id_processo, EntityManager manager) {
        return manager.find(Processo.class, id_processo);
    }
}