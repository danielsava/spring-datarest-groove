package app.service

import app.model.Produto
import app.repository.ProdutoRepository
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import javax.annotation.PostConstruct
import java.time.LocalDate

@Slf4j
@Service
class ProdutoService {


    @Autowired
    ProdutoRepository dao;


    @PostConstruct
    private void init() {
        //inserir()
        consultar()
    }


    @Transactional
    void inserir() {

        Produto p1 = Produto.of()
                .nome("Produto 1")
                .dataInicio(LocalDate.of(2022, 1, 5))
                .ativo(false)
            .build()

        Produto p2 = Produto.of()
                .nome("Produto 2")
                .dataInicio(LocalDate.of(2022, 10, 1))
                .ativo(true)
            .build()

        Produto p3 = Produto.of()
                .nome("Produto 3")
                .dataInicio(LocalDate.of(2022, 06, 06))
                .ativo(true)
            .build()

        dao.save(p1)
        dao.save(p2)
        dao.save(p3)

    }


    void consultar() {

        this.dao.findAll().forEach( p -> log.info(" Produto: ${p.toString()} " ))
    }


    String teste() {

        return "teste"
    }


}
