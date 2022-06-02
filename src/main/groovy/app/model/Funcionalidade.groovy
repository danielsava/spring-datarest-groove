package app.model

import app.model.validation.SecondOrder
import estrutura.model.jpa.EntidadeJPA
import groovy.transform.builder.Builder

import javax.persistence.Entity
import javax.validation.GroupSequence
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity @Builder(builderMethodName = "of")
@GroupSequence([ Funcionalidade, SecondOrder ])
class Funcionalidade extends EntidadeJPA {


    @NotBlank(message = "Informe o nome")
    String nome

    @Size(min = 4, message = "Descrição muito curta", groups = SecondOrder)
    @NotBlank(message = "Informe a descrição")
    String descricao



    void setNome(String nome) {
        this.nome = nome.trim()
    }

    void setDescricao(String descricao) {
        this.descricao = descricao.trim()
    }

}
