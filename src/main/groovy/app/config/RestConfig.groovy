package app.config

import app.model.Funcionalidade
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer
import org.springframework.stereotype.Component
import org.springframework.web.servlet.config.annotation.CorsRegistry


@Component
class RestConfig implements RepositoryRestConfigurer {



    // Comentário teste


    @Override
    void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        config
            .exposeIdsFor(Funcionalidade)
            //.setBasePath("/api")

        cors
            .addMapping("/**")
            .allowedMethods("*")
            //.allowedOrigins("*")
    }
}
