package estrutura.model.jpa

import estrutura.model.Entidade
import org.apache.commons.lang3.builder.ReflectionToStringBuilder
import org.apache.commons.lang3.builder.ToStringStyle

import javax.persistence.*
import java.time.LocalDateTime

@MappedSuperclass
abstract class EntidadeJPA implements Entidade<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    @Version
    @Column(name = "versao", nullable = false)
    Long versao

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 10)
    Status status

    @Column(name = "data_criacao", nullable = false, updatable = false)
    LocalDateTime dataCriacao

    @Column(name = "data_alteracao")
    LocalDateTime dataAlteracao


    @PrePersist
    private void prePersist() {
        status = Status.ATIVO
        dataCriacao = LocalDateTime.now()
    }

    @PreUpdate
    private void preUpdate() {
        dataAlteracao = LocalDateTime.now()
    }


    @Override
    boolean equals(o) {

        if (this.is(o)) return true

        if (getClass() != o.class) return false

        EntidadeJPA that = (EntidadeJPA) o

        if (id != that.id) return false

        return true
    }


    @Override
    int hashCode() {
        return (id != null ? id.hashCode() : 0)
    }

    @Override
    String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE)
    }

}
