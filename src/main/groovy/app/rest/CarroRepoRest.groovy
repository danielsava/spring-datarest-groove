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
interface CarroRepoRest extends PagingAndSortingRepository<Produto, Long> {




}