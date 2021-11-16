package br.com.cleiton.peopleapi.controller;

import br.com.cleiton.peopleapi.dto.MessageResponseDTO;
import br.com.cleiton.peopleapi.dto.request.PersonDTO;
import br.com.cleiton.peopleapi.entity.Person;
import br.com.cleiton.peopleapi.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/people")
public class PersonController {

    private PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return this.service.createPerson(personDTO);
    }

}
