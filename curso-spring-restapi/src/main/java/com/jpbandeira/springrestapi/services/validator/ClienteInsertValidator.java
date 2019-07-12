package com.jpbandeira.springrestapi.services.validator;

import com.jpbandeira.springrestapi.controller.exception.FieldMessage;
import com.jpbandeira.springrestapi.domain.Cliente;
import com.jpbandeira.springrestapi.dto.ClienteNewDto;
import com.jpbandeira.springrestapi.enums.TipoCliente;
import com.jpbandeira.springrestapi.repositories.ClienteRepository;
import com.jpbandeira.springrestapi.services.validator.br.BR;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidatorContext;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDto> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void initialize(ClienteInsert ann) {
    }

    @Override
    public boolean isValid(ClienteNewDto objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        if(objDto.getTipoCliente().equals(TipoCliente.PESSOAFISICA.getCodigo()) && !BR.isValidCPF(objDto.getCpfOuCnpj())){
            list.add(new FieldMessage("cpfOuCnpj", "CPF invalido"));
        }

        if(objDto.getTipoCliente().equals(TipoCliente.PESSOAJURIDICA.getCodigo()) && !BR.isValidCPF(objDto.getCpfOuCnpj())){
            list.add(new FieldMessage("cpfOuCnpj", "CNPJ invalido"));
        }

        Cliente cLiente = clienteRepository.findByEmail(objDto.getEmail());
        if(cLiente != null){
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