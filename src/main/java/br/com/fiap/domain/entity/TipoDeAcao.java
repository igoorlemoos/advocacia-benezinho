package br.com.fiap.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_TPACAO", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NM_TPACAO"}, name = "NM_TPACAO")
})
public class TipoDeAcao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TPACAO")
    @SequenceGenerator(name = "SQ_TPACAO", sequenceName = "SQ_TPACAO")
    @Column(name = "ID_TPACAO")
    private Long id;

    @Column(name = "NM_TPACAO", nullable = false)
    private String nome;

    public TipoDeAcao() {
    }

    public TipoDeAcao(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public TipoDeAcao setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public TipoDeAcao setNome(String nome) {
        this.nome = nome;
        return this;
    }


    @Override
    public String toString() {
        return "TipoDeAcao{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
