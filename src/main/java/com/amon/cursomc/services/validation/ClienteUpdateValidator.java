package com.amon.cursomc.services.validation;

import com.amon.cursomc.domain.Cliente;
import com.amon.cursomc.domain.enums.TipoCliente;
import com.amon.cursomc.dto.ClienteDTO;
import com.amon.cursomc.repositories.ClienteRepository;
import com.amon.cursomc.resources.exception.FieldMessage;
import com.amon.cursomc.services.validation.utils.BR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ClienteRepository repo;

    @Override public void initialize(ClienteUpdate ann) {
    }

    @Override
    public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {

        Map<String, String> map = (Map) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Integer urlId = Integer.parseInt(map.get("id"));

        List<FieldMessage> list = new ArrayList<>();

        Cliente aux = repo.findByEmail(objDto.getEmail());
        if (aux != null && !aux.getId().equals(urlId)){
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