package app.service

import app.model.Produto
import app.rest.ProdutoRest
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import javax.annotation.PostConstruct
import java.time.LocalDate

@Service
class ProdutoService {


    Logger log = LoggerFactory.getLogger(ProdutoService)


    @Autowired
    ProdutoRest dao;


    @PostConstruct
    private void init() {
        log.info("Inicializando ProdutoService ...")
        //inserir()
    }


    @Transactional
    void inserir() {

        Produto p1 = Produto.of().nome("Produto 1").dataInicio(LocalDate.of(2022, 1, 5)).ativo(false)
        Produto p2 = Produto.of().nome("Produto 2").dataInicio(LocalDate.of(2022, 10, 1)).ativo(true)
        Produto p3 = Produto.of().nome("Produto 3").dataInicio(LocalDate.of(2022, 06, 06)).ativo(true)

        dao.save(p1)
        dao.save(p2)
        dao.save(p3)

    }





}
