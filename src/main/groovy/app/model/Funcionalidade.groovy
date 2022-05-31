package app.model

import estrutura.model.jpa.EntidadeJPA
import groovy.transform.builder.Builder

import javax.persistence.Entity
import javax.validation.constraints.NotEmpty

@Entity @Builder(builderMethodName = "of")
class Funcionalidade extends EntidadeJPA {


    @NotEmpty(message = "Informe o nome")
    String nome

    @NotEmpty(message = "Informe a descrição")
    String descricao


}
