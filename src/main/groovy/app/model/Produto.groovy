package app.model

import estrutura.model.jpa.EntidadeJPA
import groovy.transform.builder.Builder

import javax.persistence.Entity
import java.time.LocalDate

@Entity @Builder(builderMethodName = "of")
class Produto extends EntidadeJPA {


    String nome

    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    //@JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dataInicio

    Boolean ativo


    //
    String testeBranch


    //
    String testeBranch2


}
