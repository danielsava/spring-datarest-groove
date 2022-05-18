package app.rest

import app.model.Produto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.data.rest.core.annotation.RestResource
import org.springframework.format.annotation.DateTimeFormat

import java.time.LocalDate

@RepositoryRestResource(collectionResourceRel = "produtos", path = "produtos")
interface ProdutoRestRepository extends PagingAndSortingRepository<Produto, Long> {


    Optional<Produto> findById(Long id)

    @RestResource(path = "situacao", rel = "situacao")
    Page<Produto> findByAtivo(@Param("ativo") boolean ativo, Pageable pageable)

    @RestResource(path = "vigentes", rel = "vigentes")
    Page<Produto> findByDataInicioGreaterThan(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Param("desde") LocalDate desde, Pageable pageable)

    @RestResource(path = "ativos", rel = "ativos")
    Page<Produto> findByDataInicioGreaterThanAndAtivo(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Param("desde") LocalDate desde, @Param("ativo") boolean ativo, Pageable pageable)

}