package app.model


import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import java.time.LocalDate

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

}
