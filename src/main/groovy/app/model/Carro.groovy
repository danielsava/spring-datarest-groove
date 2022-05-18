package app.model

import estrutura.model.jpa.EntidadeJPA
import groovy.transform.builder.Builder

import javax.persistence.Entity

@Entity @Builder(builderMethodName = "of")
class Carro extends EntidadeJPA {

    String marca

    String modelo

    Integer ano

}
