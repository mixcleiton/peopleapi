package br.com.cleiton.peopleapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends Throwable {
    public PersonNotFoundException(Long id) {
        super("Não foi localizado a pessoa de ID: ".concat(id.toString()));
    }
}
