package br.com.cleiton.peopleapi.service;

import br.com.cleiton.peopleapi.dto.MessageResponseDTO;
import br.com.cleiton.peopleapi.dto.request.PersonDTO;
import br.com.cleiton.peopleapi.entity.Person;
import br.com.cleiton.peopleapi.exceptions.PersonNotFoundException;
import br.com.cleiton.peopleapi.mapper.PersonMapper;
import br.com.cleiton.peopleapi.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository repository;
    private PersonMapper mapper = PersonMapper.INSTANCE;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public MessageResponseDTO createPerson( PersonDTO personDTO) {
        Person personToSave = mapper.toModel(personDTO);

        Person savedPerson = this.repository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID ".concat(savedPerson.getId().toString()))
                .build();
    }

    public List<PersonDTO> getAll() {

        return this.repository.findAll()
                .stream()
                .map(this.mapper::toDTO)
                .collect(Collectors.toList());

    }

    public PersonDTO getById(Long id) throws PersonNotFoundException {

        return this.repository
                .findById(id)
                .map(this.mapper::toDTO)
                .orElseThrow(() -> new PersonNotFoundException(id));

    }
}
