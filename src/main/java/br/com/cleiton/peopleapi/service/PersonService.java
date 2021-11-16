package br.com.cleiton.peopleapi.service;

import br.com.cleiton.peopleapi.dto.MessageResponseDTO;
import br.com.cleiton.peopleapi.dto.request.PersonDTO;
import br.com.cleiton.peopleapi.entity.Person;
import br.com.cleiton.peopleapi.mapper.PersonMapper;
import br.com.cleiton.peopleapi.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

}
