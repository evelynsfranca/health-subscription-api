package com.healthsubscriptionapi;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.healthsubscriptionapi.model.Client;
import com.healthsubscriptionapi.model.Partner;
import com.healthsubscriptionapi.model.Product;
import com.healthsubscriptionapi.model.enumeration.PartnerName;
import com.healthsubscriptionapi.repository.ClientRepository;
import com.healthsubscriptionapi.repository.PartnerRepository;
import com.healthsubscriptionapi.repository.ProductRepository;

@SpringBootApplication
@ComponentScan("com.healthsubscriptionapi")
public class HealthsubscriptionapiApplication implements CommandLineRunner {

    @Autowired
    PartnerRepository partnerRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ClientRepository clientRepository;

    public static void main(String[] args) {
        SpringApplication.run(HealthsubscriptionapiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Client clientAcme = new Client();
        clientAcme.setName("Acme Co");
        clientAcme.setProducts(new ArrayList<>());

        Client acme = clientRepository
                .findByName(clientAcme.getName())
                .orElseGet(() -> clientRepository.save(clientAcme));

        Client clientTioPatinhas = new Client();
        clientTioPatinhas.setName("Tio Patinhas Bank");
        clientTioPatinhas.setProducts(new ArrayList<>());

        Client tioPatinhas = clientRepository
                .findByName(clientTioPatinhas.getName())
                .orElseGet(() -> clientRepository.save(clientTioPatinhas));

        Arrays.stream(PartnerName.values())
                .forEach(it -> {

                    Partner entity = new Partner();
                    entity.setName(it);
                    Partner savedPartner = partnerRepository.findByName(it)
                            .orElseGet(() -> partnerRepository.save(entity));

                    Product newProduct = new Product();
                    newProduct.setPartner(savedPartner);
                    newProduct.setName(it + " - Product One");

                    productRepository
                            .findByName(newProduct.getName())
                            .ifPresentOrElse(
                                    (value) -> {
                                        System.out.println(value);
                                    },
                                    () -> {

                                        Product savedProduct = productRepository.save(newProduct);

                                        if ((it == PartnerName.NORTE_EUROPA
                                                || it == PartnerName.DENTAL_SORRISO)
                                                && !acme.getProducts().contains(newProduct)) {

                                            acme.getProducts().add(savedProduct);
                                            clientRepository.save(acme);
                                        }

                                        if ((it == PartnerName.PAMPULHA_INTRAMEDICA
                                                || it == PartnerName.MENTE_SA_CORPO_SAO
                                                || it == PartnerName.DENTAL_SORRISO)
                                                && !tioPatinhas.getProducts().contains(newProduct)) {

                                            tioPatinhas.getProducts().add(savedProduct);
                                            clientRepository.save(tioPatinhas);
                                        }

                                    });
                });

    }
}
