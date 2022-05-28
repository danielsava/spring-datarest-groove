package app.repository

import app.model.Funcionalidade
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.web.bind.annotation.CrossOrigin

@CrossOrigin(origins = "*")
@RepositoryRestResource(collectionResourceRel = "funcionalidades", path = "funcionalidade")
interface FuncionalidadeRepository extends PagingAndSortingRepository<Funcionalidade, Long> {

}
