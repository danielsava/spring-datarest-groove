package app.model

import estrutura.model.jpa.EntidadeJPA

import javax.persistence.Entity
import java.time.LocalDate

@Entity
class Produto extends EntidadeJPA {


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
