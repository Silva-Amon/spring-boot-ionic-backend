package com.amon.cursomc.services.validation;

import com.amon.cursomc.domain.Cliente;
import com.amon.cursomc.domain.enums.TipoCliente;
import com.amon.cursomc.dto.ClienteNewDTO;
import com.amon.cursomc.repositories.ClienteRepository;
import com.amon.cursomc.resources.exception.FieldMessage;
import com.amon.cursomc.services.validation.utils.BR;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

    @Autowired
    private ClienteRepository repo;

    @Override public void initialize(ClienteInsert ann) {
    }

    @Override
    public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) &&
                !BR.isValidSsn(objDto.getCpfOuCnpj())){
            list.add(new FieldMessage("CpfOuCnpj", "CPF inválido"));
        }
        if (objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) &&
                !BR.isValidTfn(objDto.getCpfOuCnpj())){
            list.add(new FieldMessage("CpfOuCnpj", "CNPJ inválido"));
        }

        Cliente aux = repo.findByEmail(objDto.getEmail());
        if (aux != null){
            list.add(new FieldMessage("email", "Email já existente"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}