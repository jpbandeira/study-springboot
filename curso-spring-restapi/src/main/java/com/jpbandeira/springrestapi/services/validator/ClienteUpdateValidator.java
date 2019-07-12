package com.jpbandeira.springrestapi.services.validator;

import com.jpbandeira.springrestapi.controller.exception.FieldMessage;
import com.jpbandeira.springrestapi.domain.Cliente;
import com.jpbandeira.springrestapi.dto.ClienteDto;
import com.jpbandeira.springrestapi.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDto> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void initialize(ClienteUpdate ann) {
    }

    @Override
    public boolean isValid(ClienteDto objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        Cliente clienteEmail = clienteRepository.findByEmail(objDto.getEmail());
        if(clienteEmail != null && clienteEmail.getEmail() == objDto.getEmail()){
            list.add(new FieldMessage("email", "E-mail já exixstente"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}