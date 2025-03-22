package com.healthsubscriptionapi.facade.validation.employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.healthsubscriptionapi.facade.dto.employee.EmployeeToCreateDTO;
import com.healthsubscriptionapi.model.Client;
import com.healthsubscriptionapi.model.Product;
import com.healthsubscriptionapi.service.ClientService;
import com.healthsubscriptionapi.service.ProductService;
import com.healthsubscriptionapi.service.exception.BadRequestException;

@Service
public class CreateEmployeeFormsValidation {

    private final List<String> errors = new ArrayList<>();

    private final ClientService clientService;
    private final ProductService productService;

    public CreateEmployeeFormsValidation(
            ClientService clientService,
            ProductService productService) {
        this.clientService = clientService;
        this.productService = productService;
    }

    public void create(EmployeeToCreateDTO dto) {
        errors.clear();

        validateFormByPartner(dto);
        validateClientProducts(dto);

        if (errors.size() > 0) {
            throw new BadRequestException(errors.toString());
        }
    }

    private void validateFormByPartner(EmployeeToCreateDTO dto) {
        Arrays.stream(CreateEmployeeFormsConstants.values())
                .filter(it -> it.getType("GERAL").equals("GERAL"))
                .forEach(it -> {
                    if (Boolean.FALSE.equals(it.getPredicate().test(dto))) {
                        errors.add("\n - " + it.getType(it.name()) + " - " + it.getMessage() + "\n");
                        throw new BadRequestException(errors.toString());
                    }
                });

        dto.getProducts().stream()
                .map(it -> productService.get(it.getId()))
                .map(it -> it.getPartner().getName())
                .forEach(partner -> {
                    Arrays.stream(CreateEmployeeFormsConstants.values())
                            .filter(it -> it.getType(partner.name()).equals(partner.name()))
                            .forEach(it -> {
                                if (Boolean.FALSE.equals(it.getPredicate().test(dto))) {
                                    errors.add("\n - " + it.getType(it.name()) + " - " + it.getMessage() + "\n");
                                    throw new BadRequestException(errors.toString());
                                }
                            });
                });
    }

    private void validateClientProducts(EmployeeToCreateDTO dto) {
        Client client = clientService.get(dto.getClient().getId());
        List<Product> products = productService.getAllByClientId(client.getId());

        products
                .forEach(product -> dto.getProducts().stream()
                        .filter(it -> !it.getId().equals(product.getId()))
                        .forEach(it -> errors.add("\n - Invalid Product.\n")));
    }

}
