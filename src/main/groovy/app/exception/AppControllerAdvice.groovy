package app.exception


import groovy.util.logging.Slf4j
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

import javax.validation.ConstraintViolationException

@Slf4j
@ControllerAdvice
class AppControllerAdvice extends ResponseEntityExceptionHandler {


    // comentário teste branch

    @ExceptionHandler(ConstraintViolationException)
    protected ResponseEntity<List<?>> beanValidationException(ConstraintViolationException e) {

        def validacoes = e.constraintViolations
                .collect { [field: it.propertyPath.toString(), message: it.messageTemplate]}

        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(validacoes)

    }



}
