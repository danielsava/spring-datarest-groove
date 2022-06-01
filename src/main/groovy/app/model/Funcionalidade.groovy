package app.model


import app.model.validation.SecondOrder
import estrutura.model.jpa.EntidadeJPA
import groovy.transform.builder.Builder

import javax.persistence.Entity
import javax.validation.GroupSequence
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

@Entity @Builder(builderMethodName = "of")
@GroupSequence([ Funcionalidade, SecondOrder ])
class Funcionalidade extends EntidadeJPA {


    @NotBlank(message = "Informe o nome")
    String nome

    @Min(value = 2L, message = "Descrição muito curta", groups = SecondOrder)
    @NotBlank(message = "Informe a descrição")
    String descricao


}
