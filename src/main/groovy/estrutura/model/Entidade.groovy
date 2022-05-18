package estrutura.model

interface Entidade<PK extends Serializable> extends Serializable {



    interface Schema {

        String RH = "rh"

        String CONTABIL = "contabil"

    }

    enum Status {
        ATIVO, INATIVO
    }

    PK getId()

    Status getStatus()

}