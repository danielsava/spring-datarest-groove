package app.model


import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    String nome

    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    //@JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dataInicio

    Boolean ativo

    LocalDateTime createAt

    Produto() {
        createAt = LocalDateTime.now()
    }

    static Produto of() {
        return new Produto()
    }


    Produto nome(String nome) {
        this.nome = nome
        return this
    }

    Produto dataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio
        return this
    }

    Produto ativo(boolean ativo) {
        this.ativo = ativo
        return this
    }


    boolean equals(o) {

        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Produto produto = (Produto) o

        if (id != produto.id) return false

        return true
    }

    int hashCode() {
        return (id != null ? id.hashCode() : 0)
    }

}
