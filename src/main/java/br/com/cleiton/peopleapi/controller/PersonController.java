package br.com.cleiton.peopleapi.controller;

import br.com.cleiton.peopleapi.dto.MessageResponseDTO;
import br.com.cleiton.peopleapi.dto.request.PersonDTO;
import br.com.cleiton.peopleapi.entity.Person;
import br.com.cleiton.peopleapi.exceptions.PersonNotFoundException;
import br.com.cleiton.peopleapi.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PersonDTO> getAll() {
        return this.service.getAll();
    }

    @GetMapping("{id}")
    public PersonDTO getById(@PathVariable Long id) throws PersonNotFoundException {
        return this.service.getById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
        this.service.deleteById(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO updatePerson(@PathVariable Long id,
                                           @Valid @RequestBody PersonDTO personDTO)
        throws PersonNotFoundException {
        return this.service.updatePerson(id, personDTO);
    }
}
